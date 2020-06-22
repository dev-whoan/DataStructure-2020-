package week10.Assignment02;

import java.util.ArrayList;
public class MyHashTable {
	//ArrayList 사용
	private class MyNode{
		private Object key;
		private Object element;
		
		MyNode(Object k, Object e){
			key = k;
			element = e;
		}
		
		void setKey(Object k) {	this.key = k;	}
		void setElement(Object e) {	this.element = e;	}
		
		Object getKey() {	return this.key;	}
		Object getElement() {	return this.element;	}
		
		void clear() {
			this.key = null;
			this.element = null;
		}
	}
	/*
	 * ArrayList 없이 MyNode로 리스트를 꾸릴 때
	private class MyNode{
		private Object key;
		private Object element;
		private MyNode next;
		private MyNode prev;
		
		MyNode(Object k, Object e, MyNode n, MyNode p){
			key = k;
			element = e;
			next = n;
			prev = p;
		}
		
		void setKey(Object k) {	this.key = k;	}
		void setElement(Object e) {	this.element = e;	}
		void setNext(MyNode n){	this.next = n;	}
		void setPrev(MyNode n) {	this.prev = n;	}
		
		Object getKey()	{	return	this.key;	}
		Object getElement() {	return this.element;	}
		MyNode getNext() { return this.next; }
		MyNode getPrev() {	return this.prev;	}
		
		private MyNode getTailNode()
		{
			MyNode tailNode = this;
			while(tailNode.next != null) {
				tailNode = tailNode.next;
			}
			
			return tailNode;
		}
		
		void clear() {
			key = null;
			element = null;
			next = null;
			prev = null;
		}
	}
	*/
	private ArrayList bucketArray;	//Bucket Array
	private int bucketCapacity;		//Bucket size
	private int size;
	
	private float loadFactor;		//load factor		size / capacity
	
	MyHashTable(int initialCapacity){
		bucketCapacity = initialCapacity;
		bucketArray = new ArrayList<>(bucketCapacity);
		for(int i = 0; i < bucketCapacity; i++)
			bucketArray.add(null);
		
		size = 0;
	}
	
	MyHashTable(int initialCapacity, float loadFactor){
		bucketCapacity = initialCapacity;
		bucketArray = new ArrayList<>(bucketCapacity);
		for(int i = 0; i < bucketCapacity; i++)
			bucketArray.add(null);
		
		size = 0;
		this.loadFactor = loadFactor;
	}
	
	private int hashFunc(String k) {
		int h = 0;
		int shiftLeft = 5;
		for(int i = 0; i < k.getBytes().length; i++) {
			h = (h << shiftLeft ) | ( h >>> ((8 * k.getBytes().length) - shiftLeft));
			h += (int)k.charAt(i);
		}
		//mod 연산
		return Math.abs(h % bucketCapacity);
	}
	
	public int size() {
		return size;
	}
	
	public String get(String k) {

		if(size() == 0)
			return null;
		MyNode result = null;
		ArrayList<MyNode> nodeList = (ArrayList<MyNode>) bucketArray.get(hashFunc(k));
		
		if(nodeList == null)
			return null;
		
		for(MyNode node : nodeList) {
			if(node.getKey() == k)
			{
				result = node;
				break;
			}
		}
		
		return (result != null ? result.getElement().toString() : null);
		/*
		 * MyNode를 이용한 구현
		if(size() == 0)
			return null;
		
		MyNode rootNode = (MyNode) bucketArray.get(hashFunc(k));
		
		if(rootNode == null)
			return null;
		
		MyNode pNode = rootNode;
		while(pNode.getNext() != null)
		{
			if(pNode.getKey() == k) 
				break;
			
			pNode = pNode.getNext();
		}
		
		if(pNode == null)
			return null;
		
		return pNode.getElement().toString();
		*/
	}
	
	public String put(String k, String v) {
		Object result = bucketArray.get(hashFunc(k));
		String returnValue = null;
		ArrayList<MyNode> nodeList = null;
		
		if(result != null)
		{
			nodeList = (ArrayList<MyNode>) bucketArray.get(hashFunc(k));
			for(MyNode node : nodeList)
			{
				if(node.getKey() == k)
				{
					//Node값 반환 및 변경
					returnValue = node.getElement().toString();
					node.setElement(v);
					return returnValue;	//사이즈 변화 없음.
				}
			}
			//동일한 키값을 가진게없다면 새로 추가해줘야함
			nodeList.add(new MyNode(k, v));
			bucketArray.set(hashFunc(k), nodeList);
			size++;
			return returnValue;
		}
		nodeList = new ArrayList<MyNode>();
		nodeList.add(new MyNode(k, v));
		bucketArray.set(hashFunc(k), nodeList);
		
		size++;
		
		if(getLoadFactor() >= loadFactor)
		{
			rehash(bucketCapacity * 2);
		}
		return returnValue;
		/*
		 * ArrayList 없이 MyNode로만 구현
		if(result != null)
		{
			MyNode bucketNode = (MyNode) bucketArray.get(hashFunc(k));
			MyNode pNode = bucketNode;
			while(pNode.getNext() != null)
			{
				if(pNode.getElement() == v) 
					break;
				
				pNode = pNode.getNext();
			}
			
			//해당하는 값을 가지는 노드를 찾았다면 반환하고 변경
			if(pNode.getElement() == v)
			{
				returnValue = (String) pNode.getElement();
				pNode.setElement(v);
				
			}else {
				//동일한 키 값이 없으면
				//새 노드 추가
				MyNode tempNode = new MyNode(k, v, null, null);
				tempNode.setNext(bucketNode);
				bucketNode.setPrev(tempNode);
				bucketArray.set(hashFunc(k), tempNode);
			}
		}else {
			bucketArray.set(hashFunc(k), new MyNode(k, v, null, null));
		}
		size++;
		return returnValue;
		*/
	}
	
	public String remove(String k) {
		ArrayList<MyNode> nodeList = (ArrayList<MyNode>) bucketArray.get(hashFunc(k));
		MyNode result = null;
		
		for(int i = 0; i < nodeList.size(); i++) {
			MyNode node = nodeList.get(i);
			if(node.getKey() == k)
			{
				result = node;
				node.clear();
				nodeList.remove(i);
				break;
			}
		}
		
		if(nodeList.size() < 1)
			bucketArray.set(hashFunc(k), null);
		
		size--;
		
		if(getLoadFactor() >= loadFactor)
			rehash(bucketCapacity * 2);
		
		return (result != null ? result.getElement().toString() : null);
		/*
		 * MyNode
		MyNode rootNode = (MyNode) bucketArray.get(hashFunc(k));
		
		if(rootNode == null)
			return null;
		
		MyNode pNode = rootNode;
		while(pNode.getNext() != null)
		{
			if(pNode.getKey() == k)
				break;
			
			pNode = pNode.getNext();
		}
		
		MyNode prevNode = pNode.getPrev();
		prevNode.setNext(pNode.getNext());
		pNode.clear();
		
		bucketArray.remove(hashFunc(k));
		
		size--;
		return null;
		*/
	}
	
	private void rehash(int capacity) {
		//기준을 넘어가면 리해싱
		//이전 해시 값, 현재 해시 값
		ArrayList prevArray = bucketArray;
		bucketCapacity = capacity;
		int prevSize = size;
		size = 0;
		bucketArray = new ArrayList(bucketCapacity);
		for(int i = 0; i < bucketCapacity; i++)
			bucketArray.add(null);
		
		for(int i = 0; i < prevArray.size(); i++)
		{
			ArrayList<MyNode> temp = (ArrayList<MyNode>) prevArray.get(i);
			
			if(temp != null) {
				for(int j = 0; j < temp.size(); j++) {
					
					MyNode v = temp.get(j);
					String key = v.getKey().toString();
					String element = v.getElement().toString();
					
					put(key, element);
				}
			}
		}
		
		size = prevSize;
	}
	
	public float getLoadFactor() { return ((float) size / (float) bucketCapacity); }
}
