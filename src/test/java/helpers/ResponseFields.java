package helpers;

public enum ResponseFields {
    SUCCESS("success"),
    MESSAGE("message"),
    ACCESSTOKEN("accessToken"),
    NAME("name");

    private final String value;

    ResponseFields(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
