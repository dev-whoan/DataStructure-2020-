package week12;

import java.util.ArrayList;

public class MyBST extends MyBinTree{

	MyBST(){	super();	}
	MyBST(Object e){	super(e);	}
	//inorder Ž���� ���� list
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
					//������� ã�°ű� ������ result�� ���� ��� + 1
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
			//��尡 ���ܳ���� null
			if(target == null)
				return null;
			
			//�� ã���� ��ȯ
			if((int) target.element() == (int) k) {
				result = target;
				break;
			}//������ �ަU
			else if((int) k < (int) target.element()) {
				target = target.left();
			}else {
				//ũ�� ������
				target = target.right();
			}
		}
		//ã���� print ���ֱ�
		if(result != null)
			System.out.println( ((MyBinNode) result).element() + " is exists on BST");
		else
			System.out.println( (int) k + " is not exists on BST");
		return result;
	}
	public ArrayList findAll(Object k) {
		//����Ʈ�� ��Ƽ� ��ȯ
		ioList.clear();
		ioFindAll(this.root(), k);
		
		return ioList;
		
	}
	
	public Object insert(Object k) {
		//�Ѹ����� ����
		MyBinNode temp = this.root();
		while(true){
			//���� ������ �� �� �� �ִ� ������
			if((int)temp.element() == (int)k) {
				if(this.hasLeft(temp)) {
					temp = temp.left();
				}else if(this.hasRight(temp)) {
					temp = temp.right();
				}else {
					break;
				}
			}
			//������ ������
			else if((int)temp.element() < (int)k) {
				if(!this.hasRight(temp)) {
					this.inserRight(temp, k);
					break;
				}else {
					temp = temp.right();
				}
			}
			//ũ�� ����
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
		//root���� ����� Ž���Ѵ�
		MyBinNode temp = this.root();
		Object result = null;
		
		while(true) {
			//��尡 ���ܳ���� null
			if(temp == null) 
				return null; 
			
			//������ ��ȯ
			if( (int) temp.element() == (int) k) {
				if(this.hasLeft(temp) && this.hasRight(temp)) {
					MyBinNode nextNode = this.nextNode(temp);
					temp.setElement(nextNode.element());
					result = this.remove(nextNode);  
				}else {
					result = this.remove(temp);
				}
				
				break;
			}//������ ����
			else if( (int)temp.element() < (int) k) {
				temp = temp.right();
			}else {
				//ũ�� ������
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
		//inorder ��ȸ�ϸ鼭 �Ϸķ� ����
		//findAll�̶� �Ȱ���
		ioList.add(v);
		if(this.hasRight(v)) {
			ioNextNode(this.right(v));
		}
	}
	private void ioFindAll(MyBinNode v, Object k) {
		if(this.hasLeft(v)) {
			ioFindAll(this.left(v), k);
		}
		//�������� �Ŵ� ���� ����Ʈ�� �߰�
		if( (int) v.element() == (int) k)
			ioList.add(k);
		if(this.hasRight(v)) {
			ioFindAll(this.right(v), k);
		}
	}
}
