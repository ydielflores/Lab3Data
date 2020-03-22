package Lab3Exercise;

import java.util.Scanner;

import Stacks.LinkedListStack;

public class StackSort {
	
	public static LinkedListStack<Double> stackOne = new LinkedListStack<Double>();
	public static LinkedListStack<Double> stackTwo = new LinkedListStack<Double>();
	
	public static void scan() {
		Double input;
		Scanner sc = new Scanner(System.in);
		String s;
		
		System.out.println("Input a number or press enter to terminate : \n");
		s = sc.nextLine(); 

		if(s.equals("")) {
			printSets();
			sc.close();
			System.exit(0);
		}

		if(validate(s)) {
			input = new Double(s);
			
			if(stackOne.size() == 0 || stackTwo.size() ==0) {
				populate(input);
			}
			addToStack(input);
		}else {
			System.out.println("\n");
			System.out.println("Please input a valid number \n");
		}
		scan();

	}

	public static void populate(Double input) {
		if(stackOne.size() == 0) {
			stackOne.push(input);
			scan();
		}
		if(input<stackOne.top()) {
			stackTwo.push(stackOne.pop());
			stackOne.push(input);
			scan();
		}else {
			stackTwo.push(input);
			scan();
		}
	}
	
	public static void addToStack(Double input) {
		
		if(input < stackOne.top()) {
			while(input <stackOne.top()) {
				stackTwo.push(stackOne.pop());
				if(stackOne.size() == 0) {
					break;
				}
			}
			stackOne.push(input);
		}else if(input > stackTwo.top()) {
			while(input > stackTwo.top()) {
				stackOne.push(stackTwo.pop());
				if(stackTwo.size() == 0) {
					break;
				}
			}
			stackTwo.push(input);
		}else if(input.equals(stackOne.top())) {
			stackOne.push(input);
		}else if(input.equals(stackTwo.top())) {
			stackTwo.push(input);
		}else if(input > stackOne.top() && input < stackTwo.top()) {
			stackOne.push(input);
		}else if(input > stackOne.top() && input > stackTwo.top()) {
			stackTwo.push(input);
		}
	}
	
	public static boolean validate(String s) {

		try {
			double test = Double.parseDouble(s);
		}catch(NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public static void printSets() {
		LinkedListStack<Double> provStack = new LinkedListStack<Double>();
		while(stackOne.size()>0) {
			provStack.push(stackOne.pop());
		}
		while(provStack.size()> 0) {
			System.out.println(provStack.pop());
		}
		while(stackTwo.size()>0) {
			System.out.println(stackTwo.pop());
		}
	}
	
	
	public static void main(String[] arg) {
		scan();	
	}
}
