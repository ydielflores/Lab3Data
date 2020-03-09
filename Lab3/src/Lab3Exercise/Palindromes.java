package Lab3Exercise;

import Queues.DoublyLinkedQueue;
import Stacks.LinkedListStack;

public class Palindromes {

	public static boolean isPalindrome(String s) {
		s = s.toLowerCase().trim();
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
		String s = "hola";
		System.out.println(isPalindrome(s));
		s = "civic";
		System.out.println(isPalindrome(s));
		s = "race car";
		System.out.println(isPalindrome(s));
		
		s = "Step on no pets";
		System.out.println(isPalindrome(s));
	}
}
