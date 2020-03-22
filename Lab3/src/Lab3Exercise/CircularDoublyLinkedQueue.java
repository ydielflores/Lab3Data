package Lab3Exercise;

import deque.Deque;

public class CircularDoublyLinkedQueue<E> implements Deque<E>{

	@SuppressWarnings("unused")
	private class Node{
		
		private E value;
		private Node next, prev;
		
		public Node(E value, Node next, Node prev) {
			this.value = value;
			this.next = next;
			this.prev = prev;
		}
		
		public Node(E value) {
			this(value, null, null); // Delegate to other constructor
		}
		
		public Node() {
			this(null, null, null); // Delegate to other constructor
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
		
		public Node getPrev() {
			return prev;
		}

		public void setPrev(Node prev) {
			this.prev = prev;
		}
		
		public void clear() {
			value = null;
			next = prev = null;
		}				
	}
	
	Node header;
	int currentSize;
	
	public CircularDoublyLinkedQueue() {
		header = new Node();
		currentSize = 0;
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return currentSize;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size() == 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		while(!isEmpty()) {
			removeFirst();
		}
	}

	@Override
	public E getFirst() {
		// TODO Auto-generated method stub
		if(size() > 0) {
			return header.getNext().getValue();
		}
		return null;
	}

	@Override
	public E getLast() {
		// TODO Auto-generated method stub
		if(size() > 0) {
			return header.getPrev().getValue();
		}
		return null;
	}

	@Override
	public void addFirst(E element) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if(element == null) {
			throw new IllegalArgumentException("Parameter can not be null.");
		}
		Node newNode = new Node(element);
		if(size() > 0) {
			newNode.setNext(header.getNext());
			header.getNext().setPrev(newNode);
			header.setNext(newNode);
			newNode.setPrev(header);
			
		}else {
			header.setNext(newNode);
			header.setPrev(newNode);
			newNode.setNext(header);
			newNode.setPrev(header);
		}
		currentSize++;
		
	}

	@Override
	public void addLast(E element) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if(element == null) {
			throw new IllegalArgumentException("Parameter can not be null.");
		}
		Node newNode = new Node(element);
		if(size()>0) {
			header.getPrev().setNext(newNode);
			newNode.setPrev(header.getPrev());
			newNode.setNext(header);
			header.setPrev(newNode);
		}else {
			header.setNext(newNode);
			header.setPrev(newNode);
			newNode.setNext(header);
			newNode.setPrev(header);
		}
		currentSize++;
	}

	@Override
	public E removeFirst() {
		// TODO Auto-generated method stub
		E returnValue = null;
		if(size() > 1) {
			returnValue = header.getNext().getValue();
			Node toRemove = header.getNext();
			header.setNext(toRemove.getNext());
			toRemove.getNext().setPrev(header);
			toRemove.clear();
		}else if(size() == 1) {
			returnValue = header.getNext().getValue();
			header.getNext().clear();
			header.clear();
		}
		currentSize--;
		return returnValue;
	}

	@Override
	public E removeLast() {
		// TODO Auto-generated method stub
		E returnValue = null;
		if(size() > 1) {
			returnValue = header.getPrev().getValue();
			Node toRemove = header.getPrev();
			header.setPrev(toRemove.getPrev());
			toRemove.getPrev().setNext(header);
			toRemove.clear();
		}else if(size() == 1) {
			returnValue = header.getNext().getValue();
			header.getNext().clear();
			header.clear();
		}
		currentSize--;
		return returnValue;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray() {
		// TODO Auto-generated method stub
		E[] theArray = (E[])  new  Object[size()];
		
		if(size() > 0) {
			int i = 0;
			Node toTransfer = header.getNext();
			while(i<size()) {
				theArray[i++] = toTransfer.getValue();
				toTransfer = toTransfer.getNext();
			}
		}
		
		return theArray;
	}
	
}
