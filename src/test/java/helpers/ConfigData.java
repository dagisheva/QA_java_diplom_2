package helpers;

public class ConfigData {
    private static final String baseUri = "https://stellarburgers.nomoreparties.site";
    private static final String createUserPath = "/api/auth/register";
    private static final String authUserPath = "/api/auth/login";
    private static final String renewTokenPath = "/api/auth/token";
    private static final String userDataPath = "/api/auth/user";
    private static final String ordersPath = "/api/orders";
    private static final String ingredientsPath = "/api/ingredients";

    public static String returnBaseUri() {
        return baseUri;
    }

    public static String returnCreateUserPath() {
        return createUserPath;
    }

    public static String returnAuthPath() {
        return authUserPath;
    }

    public static String returnRenewTokenPath() {
        return renewTokenPath;
    }

    public static String returnUserPath() {
        return userDataPath;
    }

    public static String returnOrdersPath() {
        return ordersPath;
    }

    public static String returnIngredientsPath() {
        return ingredientsPath;
    }
}
