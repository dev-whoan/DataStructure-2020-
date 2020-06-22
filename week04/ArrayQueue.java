package week04;

interface Queue{
	boolean isEmpty();
	boolean isFull();
	void enqueue(Object itme);
	Object dequeue();
	Object peek();
	void clear();
}

public class ArrayQueue implements Queue{
	private int front;
	private int rear;
	private int queueSize;
	private Object Q[];
	
	public ArrayQueue(int queueSize)
	{
		front = -1;
		rear = -1;
		this.queueSize = queueSize;
		Q = new Object[queueSize];
	}
	
	public boolean isEmpty() {
		if(front == rear) {
			front = -1;
				rear = -1;
		}
		return (front == rear);
	}
	
	public boolean isFull() {
		System.out.println("Queue rear is: " + rear);
		return (rear == this.queueSize-1);
	}
	
	public void enqueue(Object o) {
		if(isFull()) {
			System.out.println("Queue is Full!");
		}else {
			rear = (rear+1) % this.queueSize;
			Q[rear] = o;
			System.out.println("Queue rear is: " + rear);
		}
	}
	
	public Object dequeue() {
		if(isEmpty()) {
			System.out.println("Queue is Empty!");
			return 0;
		}
		else {
			front = (front + 1) % this.queueSize;
			return Q[front];
		}
	}
	
	public Object peek() {
		if(isEmpty()) {
			System.out.println("Queue is Empty!");
			return 0;
		}else {
			return Q[front+1];
		}
	}
	
	public void clear() {
		if(isEmpty()) {
			System.out.println("Queue is already empty!");
		}
		else {
			front = -1;
			rear = -1;
			Q = new Object[this.queueSize];
			System.out.println("Queue has cleared!");
		}
	}
	
	public void printQueue() {
		if(isEmpty()) {
			System.out.println("Queue is Empty!");
		}else {
			System.out.println("Queue elements: ");
			for(int i = front+1; i <= rear; i++) {
				System.out.print(Q[i] + " ");
			}
			System.out.println();
		}
	}
}
