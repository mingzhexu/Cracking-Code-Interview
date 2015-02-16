
package unit2;

public class loopStart {
	public Node loopBegin(linkedList l){
		Node fast = l.head;
		Node slow = l.head;
		while(fast!= null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) break;
		}
		if(fast == null || fast.next == null){
			return null;
		}
		fast = l.head;
		while(slow != fast){
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}

}
