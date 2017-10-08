# Security with JWT

## Resource
https://dzone.com/articles/implementing-jwt-authentication-on-spring-boot-api

## General

We'll need the following

1. An Authentication filter
1. An Authorization filter
3. A WebSecurityConfigurerAdapter (extension) which configures both filters for Spring
4. A UserDetailsService implementation which overrides the loadUserByUsername method

And also:
- A BCryptPasswordEncoder bean
- A Class (e.g. SecurityConstants) to store some constants

## Authentication

To generate a JWT to a user who successfully logs in

Note that the authentication filter that we created extends the UsernamePasswordAuthenticationFilter class. 
When we add a new filter to Spring Security, we can explicitly define where in the filter chain we want 
that filter, or we can let the framework figure it out by itself. By extending the filter provided within 
the security framework, Spring can automatically identify the best place to put it in the security chain.

Our custom authentication filter overwrites two methods of the base class:

- attemptAuthentication: where we parse the user's credentials and issue them to the AuthenticationManager.
- successfulAuthentication: which is the method called when a user successfully logs in. 
We use this method to generate a JWT for this user.

## Authorization

> Reads the JWT token from the header and validates it. If ok; request can move on.

We have extended the BasicAuthenticationFilter to make Spring replace it in the filter chain with our 
custom implementation. The most important part of the filter that we've implemented is the private 
getAuthentication method. This method reads the JWT from the Authorization header, 
and then uses Jwts to validate the token. If everything is in place, we set the user in the SecurityContext 
and allow the request to move on.

## Integrating the Security Filters on Spring Boot

We have annotated this class with @EnableWebSecurity and made it extend WebSecurityConfigurerAdapter 
to take advantage of the default web security configuration provided by Spring Security. 

This allows us to fine-tune the framework to our needs by overwriting two methods:

- configure(HttpSecurity http): a method where we can define which resources are public and 
which are secured. In our case, we set the SIGN_UP_URL endpoint as being public and everything else as 
being secured. We also configure custom security filter in the Spring Security filter chain.
- configure(AuthenticationManagerBuilder auth): a method where we defined a custom implementation of 
UserDetailsService to load user-specific data in the security framework. 
We have also used this method to set the encrypt method used by our application (BCryptPasswordEncoder).

Spring Security doesn't come with a concrete implementation of UserDetailsService that we could use out of the box,
therefore we have to create one of our own.

## Flow

1. All calls are secured (403 forbidden), except the api/users/register call.
2. Register a new user using our provided register endpoint
3. The login endpoint is atomically generated due to our configuration. 
Calling it with our user object will let Spring generate a JWT token which is returned in the header!
4. We have to extract the token from the header on front end side and store it (e.g. localstorage of browser)
5. From then on, we can access every endpoint, as long as we use our JWT token with the correct prefix.

```

# issues a GET request to retrieve tasks with no JWT
# HTTP 403 Forbidden status is expected
curl http://localhost:8885/api/lands/test-land

# registers a new user
curl -H "Content-Type: application/json" -X POST -d '{
    "username": "testuser", 
    "email": "test@user.be", 
    "password": "thisispassword"
}' http://localhost:8885/api/users/register

# logs into the application (JWT is generated)
curl -i -H "Content-Type: application/json" -X POST -d '{
    "username": "testuser",
    "email": "test@user.be"
    "password": "thisispassword"
}' http://localhost:8080/login

# issue a POST request, passing the JWT, to create a task
# remember to replace xxx.yyy.zzz with the JWT retrieved above
curl -H "Content-Type: application/json" \
-H "Authorization: Bearer xxx.yyy.zzz" \
-X GET -d '{
    "description": "My land is cool"
}'  http://localhost:8885/api/lands/test-land-post

# issue a new GET request, passing the JWT
# remember to replace xxx.yyy.zzz with the JWT retrieved above
curl -H "Authorization: Bearer xxx.yyy.zzz" http://localhost:8885/api/lands/test-land
```