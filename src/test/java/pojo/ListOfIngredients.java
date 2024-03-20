package pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ListOfIngredients {
    @Getter @Setter private boolean success;
    @Getter @Setter private List<Data> data;
}
