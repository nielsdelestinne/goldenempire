Gold Empire
===

Build and manage your own Gold mining company.

Install
---

- run from inside project's root: `gradlew clean build`

Heroku
---
- Run locally: `heroku local web -f Procfile.test`
- Upload to Heroku
    - Push changes to master from inside root: `git push heroku master`
     - Open web-app with `heroku open`

Heroku (1 time setup)
---

1. Install the Heroku CLI, validate with `heroku --version`
2. Set the default task to build instead of stage: `heroku config:set GRADLE_TASK="build"`
3. Create the `Procfile` file
4. `heroku login`
5. `heroku create --region eu` (to create an app (and postgres db))
6. `git push heroku master` (push changes to heroku)

References:

- reference 1: `https://devcenter.heroku.com/articles/deploying-gradle-apps-on-heroku`
- reference 2: `https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku`