package week07;

public class Main {
	public static void main(String[] args) {
		MyBinTree tree = new MyBinTree('+');
		
		MyBinNode leftNode =  tree.addNode('*');
		MyBinNode rightNode = tree.addNode('*');
		
		leftNode.setLeft(new MyBinNode(2));
		leftNode.setRight(new MyBinNode('-'));
		tree.addChild(leftNode, '-');
		
		leftNode.right().setLeft(new MyBinNode(3));
		leftNode.right().setRight(new MyBinNode(1));
		
		rightNode.setLeft(new MyBinNode(3));
		rightNode.setRight(new MyBinNode(2));
		
		tree.inOrder(tree.root());
		System.out.println("\n=" + tree.postOrder(tree.root()));
	}
}
