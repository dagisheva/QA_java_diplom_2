package pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Order {
    @Getter @Setter private String _id;
    @Getter @Setter private List<Data> ingredients;
    @Getter @Setter private User owner;
    @Getter @Setter private int number;
}
