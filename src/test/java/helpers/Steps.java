package helpers;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import pojo.*;

import java.util.*;

import static io.restassured.RestAssured.given;

public class Steps {
    private static final String createUserPath = ConfigData.returnCreateUserPath();
    private static final String authUserPath = ConfigData.returnAuthPath();
    private static final String logoutPath = ConfigData.returnLogoutPath();
    private static final String renewTokenPath = ConfigData.returnRenewTokenPath();
    private static final String userPath = ConfigData.returnUserPath();
    private static final String ordersPath = ConfigData.returnOrdersPath();
    private static final String ingredientsPath = ConfigData.returnIngredientsPath();
    private static int index;
    private static User user;

    @Step("Create user step")
    public static Response createUser(String email, String password, String name) {
        user = new User(email, password, name);
        return given().header("Content-type", "application/json").and().body(user).when().post(createUserPath);
    }

    @Step("Login user step")
    public static Response loginUser(String email, String password) {
        User loginUser = new User(email, password);
        return given().header("Content-type", "application/json").and().body(loginUser).when()
                .post(authUserPath);
    }

    @Step("Get access token step")
    public static String getAccessToken(Response response) {
        return response.body().as(UserAuth.class).getAccessToken();
    }

    @Step("Delete User step")
    public static void deleteUser(String accessToken) {
        given().header("Content-type", "application/json").and()
                .header("Authorization", accessToken).when().delete(userPath);
    }

    @Step("Change User data with authorization step")
    public static Response changeUserDataWithAuthorization(String newEmail, String newPassword,
                                                           String newName, String token) {
        user = new User(newEmail, newPassword, newName);
        return given().header("Content-type", "application/json")
                .and()
                .header("Authorization", token)
                .and()
                .body(user).when().patch(userPath);
    }

    @Step("Change User data w/o authorization step")
    public static Response changeUserDataWoAuthorization(String newEmail, String newPassword, String newName) {
        user = new User(newEmail, newPassword, newName);
        return given().header("Content-type", "application/json").and()
                .body(user).when().patch(userPath);
    }

    @Step("Get orders without authorization step")
    public static Response getOrdersWoAuth() {
        return given().header("Content-type", "application/json").when().get(ordersPath);
    }

    @Step("Get orders wit authorization step")
    public static Response getOrdersWithAuth(String token) {
        return given().header("Content-type", "application/json")
                .and().header("Authorization", token)
                .when().get(ordersPath);
    }

    @Step("Get list of Ingredients step")
    public static List<Data> ingredientsList() {
        Response ingrResponse = given().header("Content-type", "application/json").when().get(ingredientsPath);
        return ingrResponse.getBody().as(ListOfIngredients.class).getData();
    }

    @Step("Get names of Ingredients step")
    public static List<String> ingredientNames() {
        List<Data> ingredientsList = ingredientsList();
        List<String> names = new ArrayList<>();
        ingredientsList.forEach((i) -> names.add(i.getName()));
        return names;
    }

    @Step("Get ids of Ingredients step")
    public static List<String> ingredientIds() {
        List<Data> ingredientsList = ingredientsList();
        List<String> ids = new ArrayList<>();
        ingredientsList.forEach((i) -> ids.add(i.get_id()));
        return ids;
    }

    @Step("Get ingredientId by index")
    public static String getIngredientIdByIndex(int index) {
        return Methods.returnItemByIndex(ingredientIds(), index);
    }

    @Step("Get ingredientName by index")
    public static String getIngredientNameByIndex() {
        return Methods.returnItemByIndex(ingredientNames(), index);
    }

    @Step("Create order ingredients")
    public static Ingredient createIngredients(String... ingredients) {
        List<String> ingredientsList = new ArrayList<>();
        for (String ingredient : ingredients) {
            ingredientsList.add(ingredient);
        }
        Ingredient orderIngredients = new Ingredient(ingredientsList);
        return orderIngredients;
    }

    @Step("Create order with Ingredient step")
    public static Response createOrderWithAuth(Ingredient ingredients, String token) {
        return given().header("Content-type", "application/json").and().header("Authorization", token).and()
                .body(ingredients).when().post(ordersPath);
    }

    @Step("Get order id")
    public static int getOrderId(Response response) {
        Order order = response.body().as(OrderInfo.class).getOrder();
        return order.getNumber();
    }

    @Step("Create order without ingredients step")
    public static Response createOrderWoAuth(Ingredient ingredient) {
        return given().header("Content-type", "application/json")
                .and().body(ingredient).when().post(ordersPath);
    }
}
