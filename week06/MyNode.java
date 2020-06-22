package week06;

import java.util.ArrayList;

public class MyNode {
	private Object element;
	private MyNode parent;
	private ArrayList<MyNode> children;
	
	MyNode(){
		element = null;
		parent = null;
		children = null;
	}
	MyNode(Object e){
		element = e;
		parent = null;
		children = null;
	}
	
	//implement the following methods
	public Object element(){
		if(element != null)
			return element;
		else
		{
			System.out.println("Node is empty!");
			return null;
		}
	}
	
	public MyNode parent() {
		if(parent != null)
			return parent;
		else {
			System.out.println("Node doesn't have parent");
			return null;
		}
	}
	
	public ArrayList<MyNode> children() {
		if(children != null)
			return children;
		else {
			return null;
		}
	}
	
	public int degree() {
		ArrayList<MyNode> tempChildren = children();
		if(tempChildren != null)
		{
			if(tempChildren.size() > 0)
				System.out.println("Node is external node.");

			return tempChildren.size();
		}
		else {
			System.out.println("Node is external node.");
			return 0;
		}
	}
	
	public void setElement(Object e) {
		this.element = e;
	}
	
	public void setParent(MyNode p) {
		this.parent = p;
	}
	
	public void setChildren(ArrayList c) {
		this.children = c;
	}
}
