package Day06_AnnotationsAndReflection.Annotations.ExcerciseProblems.OverrideCorrectly;

// Parent class Animal
class Animal {
    // Method to make sound
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Dog class that inherits from Animal
class Dog extends Animal {
    // Overriding makeSound method
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

// Main class to test the functionality
public class OverrideCorrectly {
    public static void main(String[] args) {
        // Creating an object of Dog
        Dog dog = new Dog();

        // Calling makeSound method (it will call the overridden method in Dog)
        dog.makeSound(); // Output: Dog barks
    }
}
