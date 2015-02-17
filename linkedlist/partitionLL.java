package unit2;


public class partitionLL {
	public linkedList partition(linkedList ll, int x){
		linkedList big = new linkedList();
		linkedList small = new linkedList();
		Node current = ll.head;
		
		while(current != null){
			if(current.value < x){
				small.addToEnd(current.value);
			}else{
				big.addToEnd(current.value);
			}
			current = current.next;
		}
		Node bhead = big.head;
		while(bhead != null){
			small.addToEnd(bhead.value);
			bhead = bhead.next;
		}
		
		return small;
	}

}
