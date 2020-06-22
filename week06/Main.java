package week06;

public class Main {
	
	public static void main(String args[])
	{
		MyTree tree = new MyTree();
		tree.addRoot("Computers'R Us");
		
	//	System.out.println(tree.size());	//ภ฿ตส
		
		tree.addNode("Sales");
		tree.addNode("Manufacturing");
		tree.addNode("R&D");

		//Level 0
		MyNode root = tree.root();
		
		
		
		MyNode sales = tree.getChild(root, 0);
		MyNode manufacturing = tree.getChild(root,  1);
		MyNode RnD = tree.getChild(root,  2);
		
		if(sales != null)
		{
			tree.addChild(sales, "US");
			tree.addChild(sales, "International");
		}
		
		if(manufacturing != null)
		{
			tree.addChild(manufacturing, "Laptops");
			tree.addChild(manufacturing,  "Desktops");
		}
		
		MyNode US = tree.getChild(sales, 0);
		MyNode International = tree.getChild(sales,  1);
		
		MyNode Laptops = tree.getChild(manufacturing, 0);
		MyNode Desktops = tree.getChild(manufacturing, 1);
		
		if(International != null)
		{
			tree.addChild(International, "Europe");
			tree.addChild(International, "Asia");
			tree.addChild(International, "Canada");
		}

		MyNode Europe = tree.getChild(International, 0);
		MyNode Asia = tree.getChild(International, 1);
		MyNode Canada = tree.getChild(International, 2);
		
		int height = tree.height(tree, root);
		for(int i = 0; i <= height; i++)
		{
			System.out.println("[Level " + i + "]");
			tree.printByLevel(root, i);
			System.out.println("\n");
		}
		System.out.println("*Tree size = Total " + tree.getNodeCount() + " Nodes");
	}
}
