package unit4;

import java.util.ArrayList;

import unit2.linkedList;

//contract: levelLlist: treeNode -> List of linkedlists
//given a tree and return linkedlists containing each level's value in the tree


public class levelLlist {
	public ArrayList<linkedList> levellist(Node root){
		ArrayList<linkedList> lists = new ArrayList<linkedList>();
		return levellist(root, lists, 0);
	}
	private ArrayList<linkedList> 
	levellist(Node root, ArrayList<linkedList> lists, int level){
		{
			if(root == null) return null;
			linkedList list = null;
			if(lists.size() == level){
				list = new linkedList();
				lists.add(list);
			}else{
				list = lists.get(level);
				list.addToEnd(root.value);
				levellist(root.left, lists, level + 1);
				levellist(root.right, lists, level + 1);
			}
			return lists;
		}
	}

}
