package unit2;

public class linkedList {
	Node head;
	public linkedList(){
		this.head = null;
	}
	
	public void addToEnd(int v){
		if(head == null){
			head = new Node(v);
		}else{
			Node tail = head;
			while(tail.next != null){
				tail = tail.next;	
			}
			//System.out.print(tail.value + "\n");
		    tail.next = new Node(v);
		}
	}
	
	public void addToFront(int v){
		if(head == null) head = new Node(v);
		Node newhead = new Node(v);
		newhead.next = head;
		head = newhead;
	}
	
	public void removeLast(){
		if(head == null){
			return;
		}else{
			Node prev = null; // MUST have this -> if just set current = null, doesn't work
			Node current = head;
			while(current.next != null){
				prev = current;
				current = current.next;
			}
			//System.out.println(current.value);
			prev.next = null;
		}
		
	}
	
	public int size(){
		if(head == null) return 0;
		Node next = head;
		int s = 0;
		while (next.next != null){
			s++;
			next = next.next;
		}
		return s;
	}
	public Object get(int i){
		if(i == 0) return head.value;
		Node next = head;
		while(i != 0){
			next = next.next;
			i--;
		}
		return next.value;
	}
	
	public void reverse(){
		if(head == null) {
			return;
		}else{
			Node previous = null;
			Node current = head;
			while(current.next != null){
				Node next = current.next;
				current.next = previous;
				previous = current;
				current = next;
			}
			current.next = previous;
			head = current;
			System.out.println(head.value);
		}
			
		
	}
	
	

}
