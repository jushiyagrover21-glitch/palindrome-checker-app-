import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Scanner;

public class PalindromeCheckerApp {

    // UC3: String reverse
    public static boolean stringReverse(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return str.equals(reversed);
    }

    // UC4: Two-pointer char array
    public static boolean charArrayTwoPointer(String str) {
        char[] arr = str.toCharArray();
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            if (arr[start] != arr[end]) return false;
            start++;
            end--;
        }
        return true;
    }

    // UC5: Stack
    public static boolean stackMethod(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) stack.push(ch);
        for (char ch : str.toCharArray()) if (stack.pop() != ch) return false;
        return true;
    }

    // UC6: Queue + Stack
    public static boolean queueStackMethod(String str) {
        Deque<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            queue.addLast(ch);
            stack.push(ch);
        }
        while (!queue.isEmpty()) {
            if (queue.removeFirst() != stack.pop()) return false;
        }
        return true;
    }

    // UC7: Deque
    public static boolean dequeMethod(String str) {
        Deque<Character> deque = new LinkedList<>();
        for (char ch : str.toCharArray()) deque.addLast(ch);
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }

    // UC10: Case-insensitive + ignore spaces
    public static boolean normalizedMethod(String str) {
        String normalized = str.replaceAll("\\s+", "").toLowerCase();
        int start = 0, end = normalized.length() - 1;
        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check palindrome performance:");
        String input = scanner.nextLine();

        System.out.println("\nMeasuring performance...");

        long start, end;

        // String Reverse
        start = System.nanoTime();
        boolean res1 = stringReverse(input);
        end = System.nanoTime();
        System.out.println("String Reverse: " + (end - start) + " ns, Result: " + res1);

        // Char Array Two-pointer
        start = System.nanoTime();
        boolean res2 = charArrayTwoPointer(input);
        end = System.nanoTime();
        System.out.println("Char Array Two-pointer: " + (end - start) + " ns, Result: " + res2);

        // Stack
        start = System.nanoTime();
        boolean res3 = stackMethod(input);
        end = System.nanoTime();
        System.out.println("Stack: " + (end - start) + " ns, Result: " + res3);

        // Queue + Stack
        start = System.nanoTime();
        boolean res4 = queueStackMethod(input);
        end = System.nanoTime();
        System.out.println("Queue + Stack: " + (end - start) + " ns, Result: " + res4);

        // Deque
        start = System.nanoTime();
        boolean res5 = dequeMethod(input);
        end = System.nanoTime();
        System.out.println("Deque: " + (end - start) + " ns, Result: " + res5);

        // Case-insensitive + space-ignored
        start = System.nanoTime();
        boolean res6 = normalizedMethod(input);
        end = System.nanoTime();
        System.out.println("Normalized (case-insensitive & space-ignored): " + (end - start) + " ns, Result: " + res6);

        scanner.close();
    }
}