package pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class OrderInfo {
    @Getter @Setter private boolean success;
    @Getter @Setter private String name;
    @Getter @Setter private Order order;
    @Getter @Setter private List<Order> orders;
}
