package models;

import java.util.Objects;

public class Item {
    private int id;
    private String itemName;
    private String description;
    private double price;
    private int quantity;

    public Item(){

    }

    public Item(int id, String itemName, String description, double price, int quantity) {
        this.id = id;
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
