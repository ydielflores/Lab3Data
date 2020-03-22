package Lab3Exercise;

import Queues.Queue;


public class SinglyLinkedQueue<E> implements Queue<E> {

	@SuppressWarnings("unused")
	private class Node {
		private E value;
		private Node next;

		public Node(E value, Node next) {
			this.value = value;
			this.next = next;
		}


		public Node(E value) {
			this(value, null); // Delegate to other constructor
		}

		public Node() {
			this(null, null); // Delegate to other constructor
		}

		public E getValue() {
			return value;
		}

		public void setValue(E value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public void clear() {
			value = null;
			next = null;
		}	
	}

	int currentSize;
	Node header;

	public SinglyLinkedQueue () {
		header = new Node();
		currentSize = 0;
	}



	@Override
	public void enqueue(E e) {
		// TODO Auto-generated method stub
		Node curNode, newNode;
		if(e==null) {
			throw new IllegalArgumentException("Parameter can not be null.");
		}
		if(size() == 0) {
			header.setValue(e);
		}else {
			for(curNode = header; curNode.getNext() != null; curNode = curNode.getNext());
			newNode = new Node(e);
			curNode.setNext(newNode);
		}
		currentSize++;
	}

	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			return null;
		}
		E value = header.getValue();
		if(size() == 1) {
			header.clear();
		}else {
			header = header.getNext();
		}
		currentSize--;
		return value;
	}

	@Override
	public E front() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			return null;
		}
		return header.getValue();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub

		return size()==0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		while(!isEmpty()) {
			dequeue();
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return currentSize;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray() {
		// TODO Auto-generated method stub
		
		E[] theArray = (E[]) new Object[size()];
		int i = 0;
		while(!isEmpty()) {
			theArray[i++] = dequeue();
		}
		return theArray;
	}

}
