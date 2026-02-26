import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        showWelcomeMessage();

        checkHardcodedPalindrome();

        checkUserInputPalindrome();
    }

    // UC1 – Welcome Message
    public static void showWelcomeMessage() {
        System.out.println("=================================");
        System.out.println(" Welcome to Palindrome Checker ");
        System.out.println("=================================");
    }

    // UC2 – Hardcoded Palindrome
    public static void checkHardcodedPalindrome() {
        String word = "madam";

        String reversed = new StringBuilder(word).reverse().toString();

        if (word.equals(reversed)) {
            System.out.println("\nHardcoded Check:");
            System.out.println(word + " is a Palindrome");
        } else {
            System.out.println(word + " is not a Palindrome");
        }
    }

    // UC3 & UC4 – User Input (Ignore case & spaces)
    public static void checkUserInputPalindrome() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEnter a word or sentence to check:");
        String input = scanner.nextLine();

        // Remove spaces and convert to lowercase
        String cleanedInput = input.replaceAll("\\s+", "").toLowerCase();

        String reversed = new StringBuilder(cleanedInput).reverse().toString();

        if (cleanedInput.equals(reversed)) {
            System.out.println("Result: It is a Palindrome ✅");
        } else {
            System.out.println("Result: It is NOT a Palindrome ❌");
        }

        scanner.close();
    }
}