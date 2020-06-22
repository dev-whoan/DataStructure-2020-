package week06;

import java.util.ArrayList;

public class MyTree {
	private MyNode root;
	
	MyTree(){ root = null; }
	MyTree(Object e){
		root = new MyNode(e);
		root.setChildren(new ArrayList<MyNode>());
	}
	
	//implement the following methods
	public int size() {
		
		if(root == null)
			return 0;
		
		int tempSize = 0;
		tempSize = 1+root.children().size();
		
		return tempSize;
	}
	
	public MyNode root() {
		return root;
	}
	
	public ArrayList<MyNode> children(MyNode v) {
		if(isExternal(v)) {
			System.out.println("The node is external node.");
			return null;
		}
		return v.children();
	}
	
	public boolean isExternal(MyNode v) {
		return (v.children() == null);
	}
	public MyNode addRoot(Object e) {
		root = new MyNode(e);
		root.setChildren(new ArrayList<MyNode>());
		
		return root;
	}
	
	public MyNode addNode(Object e) {
		MyNode tempNode = new MyNode(e);
		ArrayList<MyNode> tempChildren = null;
		
		if(size() <= 1)		//root만 있거나, 없음.
			tempChildren = new ArrayList<MyNode>();
		else 
			tempChildren = root.children();
			
		tempChildren.add(tempNode);
		root.setChildren(tempChildren);
		
		//부모 설정
		tempNode.setParent(root);
		
		return tempNode;
	}
	
	public MyNode addChild(MyNode v, Object e) {
		MyNode tempNode = new MyNode(e);
		
		//자식이 없으면
		ArrayList<MyNode> tempChildren;
		if(isExternal(v))
			tempChildren = new ArrayList<MyNode>();
		else	
			tempChildren = v.children();
		
		tempChildren.add(tempNode);
		v.setChildren(tempChildren);
		
		//부모 설정
		tempNode.setParent(v);
		
		return tempNode;
	}
	public MyNode addChild(MyNode v, int i, Object e) {
		MyNode tempNode = new MyNode(e);
		ArrayList<MyNode> tempChildren;
		
		//자식이 없으면
		if(isExternal(v))
			tempChildren = new ArrayList<MyNode>();
		else
			tempChildren = v.children();
		
		tempChildren.add(i, tempNode);
		v.setChildren(tempChildren);
		
		//부모 설정
		tempNode.setParent(v);
		
		return tempNode;
	}
	public MyNode setChild(MyNode v, int i, Object e) {
		
		if( i < v.children().size() ) {
			MyNode tempNode = new MyNode(e);
			ArrayList<MyNode> tempChildren;
			
			if(isExternal(v))
				tempChildren = new ArrayList<MyNode>();
			else
				tempChildren = v.children();
			
			tempChildren.set(i, tempNode);
			v.setChildren(tempChildren);
			
			
			//부모 설정
			if(tempNode.parent() == null)
				tempNode.setParent(v);	
			
			return tempNode;
		}else {
			System.out.println("[setChild] : Index " + i + " is out of bounds for length " + v.children().size());
			return null;
		}
		
	}
	public MyNode removeChild(MyNode v, int i) {
		
		if(isExternal(v)){
			System.out.println("The node is external node.");
			return null;
		}
		
		if(v.children().get(i) != null)
		{
			MyNode tempNode = v.children().get(i);
			v.children().remove(i);
			return tempNode;
		}else {
			System.out.println("The node doesn't have the child: [index : " + i + "]");
			return null;
		}
	}
	
	
	public int getNodeCount()
	{
		if(isExternal(root))
			return 1;
		
		int totalCount = 1;
		int childIndex = 0;
		MyNode tempChild = null;
		MyNode tempParent = root;
		
		while(true)
		{
			boolean pass = false;
			if(childIndex >= tempParent.children().size())
			{
				if(tempParent == root)
					break;
				else {
					//더 이상 자식이 없음.
					for(int i = 0; i < tempParent.parent().children().size(); i++) {
						if(getChild(tempParent.parent(), i) == tempParent)
						{
							totalCount += 1;	//자식이 끝난 부모도 더해준다.
							childIndex = i+1;
							tempParent = tempParent.parent();
							pass = true;
							break;
						}
					}
				}
			}
			
			if(pass)
				continue;
			
			tempChild = getChild(tempParent, childIndex);
			if(isExternal(tempChild))
			{
				totalCount += 1;
				childIndex++;
			}else {
				tempParent = tempChild;
				childIndex = 0;
			}
		}
		
		return totalCount;
	}
	
	public void printData(MyNode v) {
		System.out.print(v.element() + " ");
	}
	
	//child node 반환
	public boolean isRoot(MyNode v) {
		return (root == v);
	}
	
	public MyNode getChild(MyNode v, int i) {
		if(isExternal(v)) {
			System.out.println("The node is external node.");
			return null;
		}
		
		if( i < v.children().size())
		{
			if(v.children().get(i) != null)
				return v.children().get(i);
			else {
				System.out.println("The node doesn't have the child: [index : " + i + "]");
				return null;
			}
		}else {
			System.out.println("[getChild] : Index " + i + " is out of bounds for length " + v.children().size());
			return null;
		}
	}
	
	public void printByLevel(MyNode v, int level)
	{
		if(root != null)
		{
			//자식에 대하여
			if(level == 0)
				printData(root);
			else {
				if(!isExternal(v))
				{
					for(MyNode child : v.children())
					{
						//자식이 존재. 자식의 depth 계산
						int childDepth = depth(child);
						if(childDepth == level)
							printData(child);
						
						printByLevel(child, level);
					}
				}
			}
		}
	}
	
	public int height(MyTree T, MyNode v) {
		if(isExternal(v))
			return 0;
		int h = 0;
		for(MyNode t : v.children())
			h = Math.max(h, height(T, t));
		return 1+h;
	}
	
	public int depth(MyNode v) {
		if(isRoot(v))
			return 0;
		else
			return 1 + depth(v.parent());
	}
}
