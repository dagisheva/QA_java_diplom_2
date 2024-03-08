package helpers;

public enum ResponseCodes {
    OK(200),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    BAD_REQUEST(400),
    INTERNAL_SERVER_ERROR(500);

    private final int value;

    ResponseCodes(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
