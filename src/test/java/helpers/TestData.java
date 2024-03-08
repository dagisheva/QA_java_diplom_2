package helpers;

import com.github.javafaker.Faker;

public class TestData {
    private static final Faker faker = new Faker();
    private static final String emptyString = "";
    private static final String errorMessage = "email or password are incorrect";
    private static final String alreadyExistsMessage = "User already exists";
    private static final String requiredParameters = "Email, password and name are required fields";
    private static final String youShouldBeAuthorizedMessage = "You should be authorised";
    private static final String ingredientIdsError = "Ingredient ids must be provided";


    public static String generateLogin() {
        return faker.name().username();
    }

    public static String generatePassword() {
        return faker.funnyName().name();
    }
    public static String generateEmail() {
        return faker.internet().emailAddress();
    }

    public static String returnEmptyString() {
        return emptyString;
    }
    public static String returnErrorMessage() {
        return errorMessage;
    }

    public static String returnUserExistsMessage() {
        return alreadyExistsMessage;
    }

    public static String returnRequiredParametersMessage() {
        return requiredParameters;
    }

    public static String returnYouShouldBeAuthorizedMessage() {
        return youShouldBeAuthorizedMessage;
    }

    public static  String returnIngredientIdsError() {
        return ingredientIdsError;
    }
}
