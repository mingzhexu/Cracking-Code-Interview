package unit2;

public class removeDup{
	public void removedup(linkedList llist){
		if(llist.head == null) return;
		
		Node current = llist.head;
		
		while(current.next != null){
			Node looper = current.next;
			while(looper.next != null){
				if(looper.next.value == current.value){
					looper.next = looper.next.next;
				}else{
					looper = looper.next;
				}
			}
			current = current.next;
		}
			
		
		
	}
}
