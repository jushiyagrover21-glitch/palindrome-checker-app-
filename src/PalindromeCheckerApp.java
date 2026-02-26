import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

// Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String str);
}

// Stack-based implementation
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : str.toCharArray()) {
            if (stack.pop() != ch) {
                return false;
            }
        }

        return true;
    }
}

// Deque-based implementation
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String str) {
        Deque<Character> deque = new LinkedList<>();
        for (char ch : str.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}

// Context Class
class PalindromeCheckerContext {
    private PalindromeStrategy strategy;

    public PalindromeCheckerContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String str) {
        return strategy.isPalindrome(str);
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }
}

// Main App
public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check palindrome:");
        String input = scanner.nextLine();

        // Choose strategy
        System.out.println("Choose strategy: 1) Stack  2) Deque");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        PalindromeStrategy strategy = (choice == 1) ? new StackStrategy() : new DequeStrategy();
        PalindromeCheckerContext checker = new PalindromeCheckerContext(strategy);

        boolean result = checker.check(input);

        if (result) {
            System.out.println("The given string is a Palindrome (using selected strategy).");
        } else {
            System.out.println("The given string is NOT a Palindrome (using selected strategy).");
        }

        scanner.close();
    }
}