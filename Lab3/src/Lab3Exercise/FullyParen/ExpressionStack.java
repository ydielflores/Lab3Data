package Lab3Exercise.FullyParen;

public class ExpressionStack<E> {

	@SuppressWarnings("hiding")
	private class Node<E>{
		private E element;
		private Node<E> next;

		public Node(){
			this.setData(null);
			this.setNext(null);
		}

		public Node(E e){
			this.setData(e);
			this.setNext(null);
		}

		public E getData() {
			return element;
		}

		public void setData(E data) {
			this.element = data;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}


	}

	private Node<E> bot;

	public ExpressionStack(){
		this.bot=null;
	}


	public void push(E d) {
		Node<E> node=new Node<E>(d);
		node.setNext(this.bot);
		this.bot=node;

	}

	public E top(){
		E result=null;

		if(this.bot!=null){
			result=this.bot.getData();
		}

		return result;
	}


	public E pop(){
		E result=null;

		if(this.bot!=null){
			result=this.bot.getData();
			this.bot=this.bot.getNext();
		}

		return result;
	}

	public boolean isEmpty(){
		return this.bot==null;
	}
}

