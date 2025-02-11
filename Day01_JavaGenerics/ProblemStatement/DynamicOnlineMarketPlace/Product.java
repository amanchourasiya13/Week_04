package Day01_JavaGenerics.ProblemStatement.DynamicOnlineMarketPlace;


public class Product<T extends ProductCategory> {
    private String name;
    private double price;
    private T category; // Category associated with the product

    // Constructor to initialize Product
    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    // Method to apply discount on the product
    public void applyDiscount(double percentage) {
        this.price -= this.price * (percentage / 100);
    }

    @Override
    public String toString() {
        return "Product: " + name + ", Price: " + price + ", Category: " + category.getCategoryName();
    }
}

