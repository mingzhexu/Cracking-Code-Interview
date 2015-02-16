package unit4;

public class miniheightTree {
	public Node miniheight(int[] arr){
		return miniheight(arr, 0, arr.length - 1);
	}
	public Node miniheight(int[] arr, int start, int end){
		if(end < start){
			return null;
		}
		int mid = (start + end)/2;
		Node root = new Node(arr[mid]);
		root.left = miniheight(arr, start, mid-1);
		root.right = miniheight(arr, mid+1, end);
		return root;
	}

}
