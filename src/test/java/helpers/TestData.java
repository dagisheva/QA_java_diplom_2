package helpers;

import com.github.javafaker.Faker;

public class TestData {
    private static final Faker FAKER = new Faker();
    private static final String EMPTY_STRING = "";
    private static final String ERROR_MESSAGE = "email or password are incorrect";
    private static final String USER_ALREADY_EXISTS = "User already exists";
    private static final String REQUIRED_PARAMETERS = "Email, password and name are required fields";
    private static final String YOU_SHOULD_BE_AUTHORISED = "You should be authorised";
    private static final String INGREDIENT_IDS_ERROR = "Ingredient ids must be provided";


    public static String generateLogin() {
        return FAKER.name().username();
    }

    public static String generatePassword() {
        return FAKER.funnyName().name();
    }
    public static String generateEmail() {
        return FAKER.internet().emailAddress();
    }

    public static String returnEmptyString() {
        return EMPTY_STRING;
    }
    public static String returnErrorMessage() {
        return ERROR_MESSAGE;
    }

    public static String returnUserExistsMessage() {
        return USER_ALREADY_EXISTS;
    }

    public static String returnRequiredParametersMessage() {
        return REQUIRED_PARAMETERS;
    }

    public static String returnYouShouldBeAuthorizedMessage() {
        return YOU_SHOULD_BE_AUTHORISED;
    }

    public static  String returnIngredientIdsError() {
        return INGREDIENT_IDS_ERROR;
    }
}
