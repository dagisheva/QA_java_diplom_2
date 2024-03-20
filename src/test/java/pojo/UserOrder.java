package pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class UserOrder {
    @Getter @Setter private String _id;
    @Getter @Setter private List<String> ingredients;
    @Getter @Setter private String status;
    @Getter @Setter private String name;
    @Getter @Setter private int number;
}
