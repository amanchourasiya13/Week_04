package Day06_AnnotationsAndReflection.Reflection.IntermediateLevelProblems.RetriveAnnotationsAtRuntime;

@Author(name = "John Doe")  // Apply the @Author annotation to this class
public class Book {
    private String title;
    private int year;

    // Constructor to initialize the Book object
    public Book(String title, int year) {
        this.title = title;
        this.year = year;
    }

    // Method to display book details
    public void display() {
        System.out.println("Book Title: " + title + ", Year: " + year);
    }

    public static void main(String[] args) {
        try {
            // Use Reflection to get the class object for 'Book'
            Class<?> bookClass = Book.class;

            // Check if the @Author annotation is present on the class
            if (bookClass.isAnnotationPresent(Author.class)) {
                // Retrieve the @Author annotation
                Author authorAnnotation = bookClass.getAnnotation(Author.class);

                // Get the 'name' value from the annotation and display it
                String authorName = authorAnnotation.name();
                System.out.println("Author: " + authorName);
            }

            // Create and display the book object
            Book book = new Book("Java Programming", 2023);
            book.display();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
