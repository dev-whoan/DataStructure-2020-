package Assignment0302;

interface dQueue{
	public int size();
	public boolean isEmpty();
	public Object front();
	public void enqueue(Object o);
	public Object dequeue();
}

public class AsgStackQueue implements dQueue{
	private ArrayStack inStack;
	private ArrayStack outStack;
	private int asgSize = -1;
	
	public AsgStackQueue(int asgSize) {
		inStack = new ArrayStack(asgSize);
		outStack = new ArrayStack(asgSize);
	}
	
	public int size() {
		return inStack.size() + outStack.size();
	}
	
	public void enqueue(Object o) {
		inStack.push(o);
		System.out.println("StackQueue enqueue elements: " + inStack.peek());
	}
	
	public Object dequeue() {
		if(outStack.isEmpty()) {
		//	System.out.println("StackQueue start dequeue");
			while(!inStack.isEmpty()) {
				Object a = inStack.pop();
		//		System.out.println("StackQueue inStack -> outStack : " + a);
				outStack.push(a);
			}
		}
		return outStack.pop();
	}

	@Override
	public boolean isEmpty() {
		return (outStack.isEmpty() && inStack.isEmpty());
	}

	@Override
	public Object front() {
		Object temp = null;
		if(outStack.isEmpty()) {
			if(inStack.isEmpty()) {
				System.out.println("StackQueue is Empty!");
			}else {
				temp = inStack.peek();
			}
		}else {
			temp = outStack.peek();
		}
		
		if(temp == null)
			return 0;
		
		return temp;
	}
	
	public void printStackQueue() {
		if(isEmpty()) {
			System.out.println("StackQueue is Empty!");
		}else {
		//	System.out.println("StackQueue elements: ");
			if(!outStack.isEmpty())
				outStack.printStack();
			if(!inStack.isEmpty())
				inStack.printStack();
		}
		
	}
}

interface Stack{
	boolean isEmpty();
	boolean isFull();
	void push(Object object);
	Object pop();
	Object peek();
	void clear();
	int size();
}

class ArrayStack implements Stack{
	//holds the stack elements
	private Object S[];
	private int stackSize;
	private int top;
	
	public ArrayStack(int stackSize) {
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
		return (top+1);
	}
}
