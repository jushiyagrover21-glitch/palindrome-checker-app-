import java.util.Scanner;

public class PalindromeCheckerApp {

    // Node class for singly linked list
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to check palindrome:");
        String input = scanner.nextLine();

        // Convert string to linked list
        Node head = null;
        Node tail = null;
        for (int i = 0; i < input.length(); i++) {
            Node newNode = new Node(input.charAt(i));
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        if (isPalindrome(head)) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }

    // Check palindrome using fast & slow pointer and reverse second half
    public static boolean isPalindrome(Node head) {

        if (head == null || head.next == null) return true;

        // Find middle using slow & fast pointers
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node secondHalf = reverse(slow.next);

        // Compare halves
        Node firstHalf = head;
        Node tempSecond = secondHalf;
        boolean palindrome = true;
        while (tempSecond != null) {
            if (firstHalf.data != tempSecond.data) {
                palindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            tempSecond = tempSecond.next;
        }

        // Restore original list (optional)
        slow.next = reverse(secondHalf);

        return palindrome;
    }

    // Reverse linked list
    private static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}