package Test;

import java.time.LocalDate;

public class Product {
    private String name;
    private int quantity;
    private double price;
    private boolean inStock;
    private LocalDate expirationDate;

    public Product(String name, int quantity, double price, boolean inStock, LocalDate expirationDate) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.inStock = inStock;
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", inStock=" + inStock +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
