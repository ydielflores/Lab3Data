package Lab3Exercise;

import java.util.Scanner;

import Queues.DoublyLinkedQueue;
import Stacks.LinkedListStack;

public class Palindromes {

	public static void scan() {
		
		String s;
		
		System.out.println("Input the string you which to verify or press enter to end: ");
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		s = sc.nextLine();
		
		if(s.equals("")) {
			System.exit(0);
		}
		
		printConfirmedPalindrome(s);
		scan();
	}
	
	public static void printConfirmedPalindrome(String s) {
		if(isPalindrome(s)) {
			System.out.println("Palindrome");
		}else {
			System.out.println("Not a Palindrome");
		}
	}
	
	public static boolean isPalindrome(String s) {
		s = s.toLowerCase().replaceAll("[^a-zA-Z]","");

		DoublyLinkedQueue<Character> queue = new DoublyLinkedQueue<>();
		LinkedListStack<Character> stack = new LinkedListStack<>();

		for(int i = 0; i < s.length(); i++) {
			queue.enqueue(s.charAt(i));
			stack.push(s.charAt(i));
		}

		return isPalindromeHelper(queue, stack);
	}

	public static boolean isPalindromeHelper(DoublyLinkedQueue<Character> q , LinkedListStack<Character> s) {

		if(q.size() == 0 && s.size() == 0) {
			return true;
		}else if(q.dequeue().equals(s.pop())) {
			return isPalindromeHelper(q, s);
		}
		return false;
	}

	public static void main(String[] args) {
		scan();
	}
}
