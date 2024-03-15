package helpers;

public class ConfigData {
    private static final String BASE_URI = "https://stellarburgers.nomoreparties.site";
    private static final String CREATE_USER_PATH = "/api/auth/register";
    private static final String AUTH_USER_PATH = "/api/auth/login";
    private static final String RENEW_TOKEN_PATH = "/api/auth/token";
    private static final String USER_DATA_PATH = "/api/auth/user";
    private static final String ORDERS_PATH = "/api/orders";
    private static final String INGREDIENTS_PATH = "/api/ingredients";

    public static String returnBaseUri() {
        return BASE_URI;
    }

    public static String returnCreateUserPath() {
        return CREATE_USER_PATH;
    }

    public static String returnAuthPath() {
        return AUTH_USER_PATH;
    }

    public static String returnRenewTokenPath() {
        return RENEW_TOKEN_PATH;
    }

    public static String returnUserPath() {
        return USER_DATA_PATH;
    }

    public static String returnOrdersPath() {
        return ORDERS_PATH;
    }

    public static String returnIngredientsPath() {
        return INGREDIENTS_PATH;
    }
}
