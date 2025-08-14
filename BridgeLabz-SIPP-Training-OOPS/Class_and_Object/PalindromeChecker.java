package Class_and_Object;

public class PalindromeChecker {
    String text;
    public PalindromeChecker(String text) {
        this.text = text;
    }
    public boolean isPalindrome() {
        String cleanedText = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); // ignoring cases and non-alphanumerics
        int left = 0, right = cleanedText.length() - 1;

        while (left < right) {
            if (cleanedText.charAt(left) != cleanedText.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public void displayResult() {
        System.out.println("Text: " + text);
        if (isPalindrome()) {
            System.out.println("Result: It's a palindrome!");
        } else {
            System.out.println("Result: It's not a palindrome.");
        }
    }

    public static void main(String[] args) {
        PalindromeChecker pc1 = new PalindromeChecker("Madam");
        pc1.displayResult();

        PalindromeChecker pc2 = new PalindromeChecker("Java");
        pc2.displayResult();
    }
}
