package week12;

import java.util.ArrayList;

import week12.MyBinTree.TwoChildrenException;

public class week12 {
	public static void main(String[] args) throws TwoChildrenException {
		MyBST bst = new MyBST(6);
		bst.insert(2);
		bst.insert(9);
		bst.insert(1);
		bst.insert(4);
		bst.insert(8);
		bst.insert(9);
		System.out.println("-----BST-----");
		bst.inOrder(bst.root());	// ((124)6(89)9)
		
		System.out.println();
		bst.find(new Integer(8));
		bst.find(new Integer(3));
		bst.insert(new Integer(3));
		bst.insert(new Integer(7));
		bst.insert(new Integer(9));

		bst.remove(new Integer(1));
		bst.remove(new Integer(4));
		bst.remove(new Integer(6));
		
		bst.find(new Integer(3));
		bst.find(new Integer(6));
		ArrayList al = bst.findAll(new Integer(9));
		
		System.out.println("---findAll 9---");
		for(Object n : al) {
			System.out.print( n + " ");
		}
		System.out.println();
		
		System.out.println("-----final BST-----");
		bst.inOrder(bst.root());
		
	}
}
