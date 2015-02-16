package unit4;

import java.util.List;

public class treeMain {
	public static void main(String[] args){
		binaryTree mytree = new binaryTree();
		//treeNode root = mytree.root;
		mytree.add(5);
		mytree.add(3);
		mytree.add(1);
		mytree.add(7);
		mytree.add(9);
		mytree.add(8);
		mytree.add(10);
		mytree.add(12);
		mytree.add(2);
		System.out.println(mytree.height());
		System.out.println(mytree.minHeight());
		System.out.println(mytree.countnode());
		System.out.println(mytree.isbalance());
		System.out.println(mytree.tostring());
		System.out.println(mytree.maxNode());
		List<List<Integer>> a = mytree.levelOrderBottom();
		for(List<Integer> i : a){
			System.out.print("[");
			for(int j : i){
				System.out.print(j );
			}
			System.out.println("]");
		}
		mytree.levelorder();
	}

}
