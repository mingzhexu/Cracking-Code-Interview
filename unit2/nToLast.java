package unit2;

public class nToLast {
	public Node findN(linkedList llist, int n){
		Node head = llist.head;
		Node runner1 = head;
		Node runner2 = head;
		int i = 0;
		while(i < n - 1){
			runner1 = runner1.next;
			i++;
		}
		if(runner1 == null){
			return null;
		}
		while(runner1.next != null){
			runner2 = runner2.next;
			runner1 = runner1.next;
		}
		return runner2;
	}

}
