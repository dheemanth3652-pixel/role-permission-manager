// Example JWT Validation Logic

public class JwtValidationExample {

    public static boolean validateToken(String token) {

        if (token == null || token.isEmpty()) {
            return false;
        }

        if (!token.startsWith("Bearer ")) {
            return false;
        }

        long currentTime = System.currentTimeMillis();
        long expiryTime = currentTime + 10000;

        return expiryTime > currentTime;
    }

    public static void main(String[] args) {

        String token = "Bearer sample.jwt.token";

        if (validateToken(token)) {
            System.out.println("JWT token is valid");
        } else {
            System.out.println("Invalid JWT token");
        }
    }
}
