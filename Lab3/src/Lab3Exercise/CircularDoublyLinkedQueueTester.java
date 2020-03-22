package Lab3Exercise;

public class CircularDoublyLinkedQueueTester {
	
	public static CircularDoublyLinkedQueue <String> test = new CircularDoublyLinkedQueue<String>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test.addFirst("s");
		test.addFirst("o");
		test.addFirst("d");
		test.addFirst("u");
		test.addFirst("l");
		test.addFirst("a");
		test.addFirst("s");
		
		System.out.println("Test size() : " + test.size());
		System.out.println("Test removeFirst() : " + test.removeFirst());
		System.out.println("Test removeLast() : " + test.removeLast());
		System.out.println("Test getFirst() : " + test.getFirst());
		System.out.println("Test getLast() : " + test.getLast());
		System.out.println("Test size() despues de remover dos elementos : " + test.size());
		
		test.clear();
		
		System.out.println("Test clear() primero con size() : " + test.size() + ", el primer elemento y el ultimo deberian ser 'null' : " + test.getFirst() + ", " + test.getLast());
		
		test.addLast("s");
		test.addLast("a");
		test.addLast("l");
		test.addLast("u");
		test.addLast("d");
		test.addLast("o");
		test.addLast("s");
		
		System.out.println("Test toArray() : ");
		Object[] theArray = test.toArray();
		
		for(int i = 0; i < theArray.length; i++) {
			System.out.println(theArray[i]);
		}
		printTest(test);
	}
	
	public static void printTest(CircularDoublyLinkedQueue<String> list) {
		System.out.println("Test empty the list con removeFirst()");
		while(list.size() > 0) {
			System.out.println(list.removeFirst());
		}
	}

}
