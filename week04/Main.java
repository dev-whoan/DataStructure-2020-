package week04;

public class Main {
	public void aamain(String args[])
	{
		ArrayQueue queue = new ArrayQueue(10);
		
		queue.enqueue('A');
		queue.printQueue();
		queue.enqueue('B');
		queue.printQueue();
		queue.enqueue('C');
		queue.printQueue();
		queue.enqueue('D');
		queue.printQueue();
		queue.enqueue('E');
		queue.printQueue();
		
		queue.enqueue('F');
		queue.printQueue();
		queue.enqueue('G');
		queue.printQueue();
		queue.enqueue('H');
		queue.printQueue();
		queue.enqueue('i');
		queue.printQueue();
		queue.enqueue('J');
		queue.printQueue();
		
		queue.dequeue();
		queue.printQueue();

		queue.enqueue('K');
		queue.printQueue();
		queue.dequeue();
		queue.printQueue();
		queue.dequeue();
		queue.printQueue();
		queue.dequeue();
		queue.printQueue();
		queue.dequeue();
		queue.printQueue();
		queue.dequeue();
		queue.printQueue();
		queue.dequeue();
		queue.printQueue();
		queue.dequeue();
		queue.printQueue();
		queue.dequeue();
		queue.printQueue();
		queue.dequeue();
		queue.printQueue();
		queue.dequeue();
	}
}
