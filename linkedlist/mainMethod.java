package unit2;

public class mainMethod {
	public static void main(String[] args){
		linkedList ll = new linkedList();
		ll.addToEnd(9);
		ll.addToEnd(3);
		ll.addToEnd(5);
		
		//ll.addToFront(5);
		//ll.addToFront(6);
		
		linkedList ll2 = new linkedList();
		ll2.addToEnd(6);
		ll2.addToEnd(1);
		ll2.addToEnd(7);
		//ll.reverse();
		//ll.removeLast();
		
		//removeDup rd = new removeDup();
		//rd.removedup(ll);
		
		//nToLast ntl = new nToLast();
		//Node p = ntl.findN(ll, 3);
		//System.out.print(p.value);
		//System.out.println(2%10);
		
		//Node current = ll.head;
		//while(current != null){
		//	System.out.print(current.value);
		//	current = current.next;
		//}
		
		//sumLLNums sum = new sumLLNums();
		//linkedList newlist = sum.sumNum(ll, ll2);
		//Node current1 = newlist.head;
		//while(current1 != null){
		//	System.out.print(current1.value);
		//	current1 = current1.next;
		//}
		//Palindrome pa = new Palindrome();
		//System.out.print(pa.isPalindrome(ll));
		partitionLL pl = new partitionLL();
		linkedList parlist = pl.partition(ll2, 4);
		Node current2 = parlist.head;
		while(current2 != null){
			System.out.print(current2.value);
			current2 = current2.next;
		}
		
	
	}

}
