package pojo;

import java.util.List;

public class Order {
    private String _id;
    private List<Data> ingredients;
    private User owner;
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Data> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Data> ingredients) {
        this.ingredients = ingredients;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
