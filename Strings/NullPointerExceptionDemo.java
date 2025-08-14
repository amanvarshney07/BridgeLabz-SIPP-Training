package Strings;

public class NullPointerExceptionDemo {

    
    public static void generateException() {
        String text = null;
        System.out.println("Generating NullPointerException...");
        System.out.println(text.length());
    }

    public static void handleException() {
        String text = null;
        try {
            System.out.println("Handling NullPointerException safely...");
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            generateException();
        } catch (NullPointerException e) {
            System.out.println("Exception occurred in generateException(): " + e.getMessage());
        }

        handleException();
    }
}

