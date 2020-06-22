package week07;

public class MyBinNode extends MyNode{
	
	MyBinNode(){
		super();
	}
	
	MyBinNode(Object e){
		super(e);
	}
	
	public MyBinNode left() {
		return (MyBinNode) super.children().get(0);
	}
	
	public MyBinNode right() {
		return (MyBinNode) super.children().get(1);
	}
	
	public void setLeft (MyBinNode v) {
		super.children().set(0, v);
	}
	
	public void setRight (MyBinNode v) {
		super.children().set(1,  v);
	}
}
