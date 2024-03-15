package pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Ingredient {
    @Getter @Setter private List<String> ingredients;
    public Ingredient(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}
