package unit2;

public class sumLLNums {
		public linkedList sumNum(linkedList l1, linkedList l2){
			int carry = 0;
			int rem = 0;
			Node n1 = l1.head;
			Node n2 = l2.head;
			linkedList newlist = new linkedList();
			while(n1!= null || n2!= null){
				if (n1!=null&&n2!=null){
					int n = n1.value+n2.value;
					rem = n%10;
					newlist.addToEnd(rem+carry);
					carry = n/10;
					n1 = n1.next;
					n2 = n2.next;
				}
				if(n1 == null&&n2 != null){
					newlist.addToEnd(n2.value);
					n2 = n2.next;
				}
				if(n2 == null&&n1 != null){
					newlist.addToEnd(n1.value);
					n1 = n1.next;
				}
				
			}
			
			if(n2 == null&&n1 == null&&carry!=0){
				newlist.addToEnd(carry);
			}
			return newlist;
		}

}
