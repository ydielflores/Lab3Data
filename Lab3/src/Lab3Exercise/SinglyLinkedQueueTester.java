package Lab3Exercise;

public class SinglyLinkedQueueTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedQueue<String> test = new SinglyLinkedQueue<String>();
		
		test.enqueue("s");
		test.enqueue("a");
		test.enqueue("l");
		test.enqueue("u");
		test.enqueue("d");
		test.enqueue("o");
		test.enqueue("s");
		System.out.println("Size despues de saludos :" +test.size());
		System.out.println("Test isEmpty() :" + test.isEmpty());
		System.out.println("Test front() :" + test.front());
		System.out.println("Test dequeue() :" + test.dequeue());
		System.out.println("Test front() despues de un dequeue() :" + test.front());
		
		test.clear();
		System.out.println("Test size() despues de clear() :" + test.isEmpty());
		
		test.enqueue("s");
		test.enqueue("a");
		test.enqueue("l");
		test.enqueue("u");
		test.enqueue("d");
		test.enqueue("o");
		test.enqueue("s");
		
		
		Object [] isArrayNow = test.toArray();
		
		System.out.println("Test toArray() :");
		for(int i = 0; i < isArrayNow.length; i++) {
			System.out.println((String) isArrayNow[i]);
		}
		
		printTest(test);
	}
	
	public static void printTest(SinglyLinkedQueue<String> test) {
		System.out.println("Hard dequeue test");
		while(!test.isEmpty()) {
			System.out.println(test.dequeue());
		}
	}
}
