import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check palindrome:");
        String input = scanner.nextLine();

        if (isPalindromeRecursive(input, 0, input.length() - 1)) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }

    // Recursive palindrome check
    public static boolean isPalindromeRecursive(String str, int start, int end) {

        // Base condition: crossed over
        if (start >= end) {
            return true;
        }

        // Check characters at start & end
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call moving towards center
        return isPalindromeRecursive(str, start + 1, end - 1);
    }
}