package Queues;

public interface QueueFactory<E> {

	public Queue<E> newInstance();

}