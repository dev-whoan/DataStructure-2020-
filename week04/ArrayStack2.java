package week04;

interface Stack2{
	boolean isEmpty();
	boolean isFull();
	void push(Object object);
	Object pop();
	Object peek();
	void clear();
	int size();
}

public class ArrayStack2 implements Stack2{
	//holds the stack elements
	private Object S[];
	private int stackSize;
	private int top;
	
	public ArrayStack2(int stackSize) {
		top = -1;
		this.stackSize = stackSize;
		S = new Object[stackSize];
	}

	public boolean isEmpty()
	{
		return (top == -1);
	}
	
	public boolean isFull() {
		return (top == this.stackSize-1);
	}
	
	public void push(Object o) {
		if(isFull()) {
			System.out.println("Stack is full!");
		}else {
			S[++top] = o;
		}
	}
	
	public Object pop(){
		if (isEmpty()) {
			System.out.println("Pop Failed! Stack is Empty!");
			return 0;
		}else {
			Object temp = S[top];
			top = top - 1;
			return temp;
		}
	}
	
	public Object peek() throws java.util.EmptyStackException{
		if (isEmpty()) {
			System.out.println("Peek Failed! Stack is Empty!");
			return 0;
		}else {
			return S[top];	
		}
	}
	
	public void clear() {
		if(isEmpty()) {
			System.out.println("Stack is already Empty!");
		}else {
			top = -1;
			S = new Object[this.stackSize];
			System.out.println("Stack has cleared!");
		}
	}
	public void printStack() {
		if(isEmpty()) {
			System.out.println("Stack is Empty!");
		}
		else {
			System.out.print("Stack elements: ");
			for(int i = 0; i <= top; i++)
				System.out.print(S[i] + " ");
			
			System.out.println();
		}
	}
	
	public int size() {
		return (stackSize -(top+1));
	}
}
