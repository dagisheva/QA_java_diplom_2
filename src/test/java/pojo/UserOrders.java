package pojo;

import java.util.List;

public class UserOrders {
    private boolean success;
    private List<UserOrder> orders;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<UserOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<UserOrder> orders) {
        this.orders = orders;
    }
}
