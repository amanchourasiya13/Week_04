package Day01_JavaGenerics.ProblemStatement.DynamicOnlineMarketPlace;

public class OnlineMarketPlace {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        product.applyDiscount(percentage); // Apply the discount to the product
    }

    public static void main(String[] args) {
        // Create products from different categories
        Product<BookCategory> book = new Product<>("Java Programming Book", 50.0, new BookCategory());
        Product<ClothingCategory> clothing = new Product<>("Winter Jacket", 120.0, new ClothingCategory());
        Product<GadgetCategory> gadget = new Product<>("Smartphone", 500.0, new GadgetCategory());

        // Display product details before applying discount
        System.out.println("Before applying discount:");
        System.out.println(book);
        System.out.println(clothing);
        System.out.println(gadget);

   //we can apply discount like this but we have to use wildcard method therefore we will use dynimically.
  //    book.applyDiscount(10);   clothing.applyDiscount(20) gadget.applyDiscount(30);

        // Apply discount dynamically to each product
        applyDiscount(book, 10);  // 10% discount on book
        applyDiscount(clothing, 15); // 15% discount on clothing
        applyDiscount(gadget, 5); // 5% discount on gadget

        // Display product details after applying discount
        System.out.println("\nAfter applying discounts:");
        System.out.println(book);
        System.out.println(clothing);
        System.out.println(gadget);
    }
}

