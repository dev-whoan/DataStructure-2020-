package week12;

import java.util.ArrayList;

public class MyBST extends MyBinTree{

	MyBST(){	super();	}
	MyBST(Object e){	super(e);	}
	//inorder 탐색을 위한 list
	ArrayList<Object> ioList = new ArrayList<Object>();
	private MyBinNode nextNode (MyBinNode v) {
		//find node
		MyBinNode result = null;
		ioList.clear();
		ioNextNode(v);
		
		if(ioList.size() > 0) {
			for(int i = 0; i < ioList.size(); i++) {
				MyBinNode temp = (MyBinNode) ioList.get(i);
				if((int)temp.element() == (int)v.element()) {
					//다음노드 찾는거기 때문에 result는 현재 노드 + 1
					result = (MyBinNode) ioList.get(i+1);
					break;
				}
			}
		}
		return result;
	}
	
	public Object find(Object k) {
		MyBinNode target = this.root();
		Object result = null;
		while(true) {
			//노드가 종단노드라면 null
			if(target == null)
				return null;
			
			//값 찾으면 반환
			if((int) target.element() == (int) k) {
				result = target;
				break;
			}//작으면 왼쪾
			else if((int) k < (int) target.element()) {
				target = target.left();
			}else {
				//크면 오른쪽
				target = target.right();
			}
		}
		//찾으면 print 해주기
		if(result != null)
			System.out.println( ((MyBinNode) result).element() + " is exists on BST");
		else
			System.out.println( (int) k + " is not exists on BST");
		return result;
	}
	public ArrayList findAll(Object k) {
		//리스트에 담아서 반환
		ioList.clear();
		ioFindAll(this.root(), k);
		
		return ioList;
		
	}
	
	public Object insert(Object k) {
		//뿌리부터 삽입
		MyBinNode temp = this.root();
		while(true){
			//값이 같으면 좌 우 중 있는 곳으로
			if((int)temp.element() == (int)k) {
				if(this.hasLeft(temp)) {
					temp = temp.left();
				}else if(this.hasRight(temp)) {
					temp = temp.right();
				}else {
					break;
				}
			}
			//작으면 오른쪽
			else if((int)temp.element() < (int)k) {
				if(!this.hasRight(temp)) {
					this.inserRight(temp, k);
					break;
				}else {
					temp = temp.right();
				}
			}
			//크면 왼쪽
			else {
				if(!this.hasLeft(temp)) {
					this.inserLeft(temp,  k);
					break;
				}else {
					temp = temp.left();
				}
			}
		}
		System.out.println( "insert : " + k + " on " + ((MyBinNode) temp).element());
		return temp;
	}
	public Object remove(Object k) throws TwoChildrenException{
		//root부터 대상을 탐색한다
		MyBinNode temp = this.root();
		Object result = null;
		
		while(true) {
			//노드가 종단노드라면 null
			if(temp == null) 
				return null; 
			
			//같으면 반환
			if( (int) temp.element() == (int) k) {
				if(this.hasLeft(temp) && this.hasRight(temp)) {
					MyBinNode nextNode = this.nextNode(temp);
					temp.setElement(nextNode.element());
					result = this.remove(nextNode);  
				}else {
					result = this.remove(temp);
				}
				
				break;
			}//작으면 왼쪽
			else if( (int)temp.element() < (int) k) {
				temp = temp.right();
			}else {
				//크면 오른쪽
				temp = temp.left();
			}
		}
		System.out.println( ((MyBinNode) result).element() + " has removed");
		return result;
	}
	
	private void ioNextNode( MyBinNode v) {
		if(this.hasLeft(v)) {
			ioNextNode(this.left(v));
		}
		//inorder 순회하면서 일렬로 정렬
		//findAll이랑 똑같이
		ioList.add(v);
		if(this.hasRight(v)) {
			ioNextNode(this.right(v));
		}
	}
	private void ioFindAll(MyBinNode v, Object k) {
		if(this.hasLeft(v)) {
			ioFindAll(this.left(v), k);
		}
		//같은값인 거는 전부 리스트에 추가
		if( (int) v.element() == (int) k)
			ioList.add(k);
		if(this.hasRight(v)) {
			ioFindAll(this.right(v), k);
		}
	}
}
