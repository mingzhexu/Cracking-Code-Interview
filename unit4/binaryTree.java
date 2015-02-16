package unit4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class binaryTree {
	
	Node root = null;
	
	public void add(int v){
		if(root == null){
			root = new Node(v);//very important!!!
		}else{
			add(v, root);
		}
	}
	private void add(int v, Node current){
		if(current.value <= v){
			if(current.left == null){
				current.left = new Node(v);
			}else{
				add(v, current.left);
			}
	    }else{
	    	if(current.right == null){
	    		current.right = new Node(v);
	    	}else{
	    		add(v, current.right);
	    	}
	    }
	}
	
	public String tostring(){
		return tostring(root);
	}
	private String tostring(Node current){
		if(current == null){
			return "";
		}
		String leftside = tostring(current.left);
		String rightside = tostring(current.right);
		return leftside + current.value + rightside;
	}
	
	public int height(){
		return height(root);
	}
	private int height(Node current){
		if(current == null){
			return 0;
		}
		if(current.left == null && current.right != null){
			return height(current.right) + 1;
		}
		if(current.left != null && current.right == null){
			return height(current.left) + 1;
		}
		int l = height(current.left);
		int r = height(current.right);
		if(l < r){
			return r + 1;
		}else{
			return l + 1;
		}
		//return 1+ Math.max(height(current.left), height(current.right));
		//these two approaches BOTH work
	}
    public int minHeight(){
    	return minHeight(root);
		
	}
	public int minHeight(Node current){
		if(current == null){
			return 0;
		}
		int l = height(current.left);
		int r = height(current.right);
		return l > r? r + 1 : l + 1;
	}
	
	public int countnode(){
		
		return countnode(root);
	}
	private int countnode(Node current){
		
		if(current == null){
			return 0;
		}
		
		int l = countnode(current.left);
		int r = countnode(current.right);
		
		return 1+l+r;
	}
	
	public boolean isbalance(){
		return isbalance(root);
	}
	private boolean isbalance(Node current){
		if(current == null){
			return true;
		}
		if(current.left == null && current.right == null){
			return true;
		}
	    int hdiff = height(current.left) - height(current.right);		
	    if(Math.abs(hdiff) > 1){
	    	return false;
	    }else{
	    	return isbalance(current.left) && isbalance(current.right);
	    }
	}
	
	
	public int maxNode(){
		return maxNode(root);
	}
	private int maxNode(Node current){
		if(current == null){
			return Integer.MIN_VALUE;
		}
		int leftmax = maxNode(current.left);
		int rightmax = maxNode(current.right);
		return Math.max(current.value, Math.max(leftmax,rightmax));
	}
	
	public boolean containsNode(int v){
		return containsNode(v, root);
	}
	
	private boolean containsNode(int v, Node current){
		if(current == null){
			return false;
		}
		if(current.value == v){
			return true;
		}
		return containsNode(v, current.left) || containsNode(v, current.right);
	}
	
	public void preorder(){
		preorder(root);
	}
	private void preorder(Node current){
		if(current == null) return ;
		System.out.println(current.value);
		preorder(current.left);
		preorder(current.right);
	}
	
	public void inorder(){
		if(root == null) return;
		inorder(root);
	}
	private void inorder(Node current){
		if(current == null) return;
		inorder(current.left);
		System.out.println(current.value);
		inorder(current.right);
	}
	
	public void postorder(){
		postorder(root);
	}
	private void postorder(Node current){
		if(current == null) return;
		postorder(current.left);
		postorder(current.right);
		System.out.println(current.value);
	}
	
	public void levelorder(){
		levelorder(root);
	}
	private void levelorder(Node current){
		Queue<Node> q = new LinkedList<Node>();
		q.add(current);
		Queue<Node> q1 = new LinkedList<Node>();
		while(!q.isEmpty()){
			Node node = q.remove();
			System.out.print(node.value);
			if(node.right != null){
				q1.add(node.right);//先加右边再左边，因为linkedlist的是从后面加，remove是从前面删
			}
			if(node.left != null){
				q1.add(node.left);
			}
			if(q.isEmpty()){
				q = new LinkedList<Node>(q1);
				q1.clear();
			}
		}	
	}
	
	public Node FCA(Node n1, Node n2){
		return FCA(root, n1, n2);
	}
	private Node FCA(Node current, Node a, Node b){
		if(current == null) return null;
		boolean p = ischild(current.left, a);
		boolean q = ischild(current.left, b);
		if(p != q){
			return current;
		}
		Node common = p ? current.left : current.right;
		return FCA(common, a, b);
	}
	private boolean ischild(Node n, Node a){
		if(n == null) return false;
		if(n == a) return true;
		return ischild(n.left, a) && ischild(n.right, a);
	}
	
	public List<List<Integer>> levelOrderBottom(){
		return levelOrderBottom(root);
	}
	
	public List<List<Integer>> levelOrderBottom(Node current) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(current == null){
            return result;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(current);
        Queue<Node> q2 = new LinkedList<Node>();//need two queues
        List<Integer> level = new ArrayList<Integer>();//need two arraylists非常重要！！！！！
        while(!q.isEmpty()){
            
            for(int i = 0; i < q.size(); i++){
                Node node = q.remove();
                level.add(0, node.value); //linkedlist 是往后加的，所以要放到index为零的地方
                if(node.left != null) q2.add(node.left);//先左后右，因为倒着遍历，
                                         //而且linkedlist是往后加， remove是从头删除，负负得正
                if(node.right != null) q2.add(node.right);
            }
            
            if(q.isEmpty()){
            	q = new LinkedList<Node>(q2);
                q2.clear();
                List<Integer> l = new ArrayList<Integer>(level);
                result.add(0, l);//要用一个list顶上另一个不然所有的数字都是单个的[[1],[2],[3]];(应该是[[1],[2,3]])
          
                level.clear();
            }
            
        }
        return result;
        
        
    }
			
}

	

