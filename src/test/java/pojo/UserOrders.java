package pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class UserOrders {
    @Getter @Setter private boolean success;
    @Getter @Setter private List<UserOrder> orders;
}
