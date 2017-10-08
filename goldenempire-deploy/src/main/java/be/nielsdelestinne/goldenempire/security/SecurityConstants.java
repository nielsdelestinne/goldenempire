package be.nielsdelestinne.goldenempire.security;

public final class SecurityConstants {

    static final String SECRET = "78778899885545MySecretKeyToGeneratingJWT8707891006064504465645612101105655448676545";
    static final long EXPIRATION_TIME = 864_000_000; // 10 days
    static final String TOKEN_PREFIX = "Bearer ";
    static final String HEADER_STRING = "Authorization";
    static final String SIGN_UP_URL = "/api/users/register";

}
