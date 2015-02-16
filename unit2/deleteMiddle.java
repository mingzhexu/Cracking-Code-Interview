package unit2;

public class deleteMiddle {
	public boolean deleteM(Node middle){
		if(middle == null || middle.next == null){
			return false;
		}else{
			middle.value = middle.next.value;
			middle.next = middle.next.next;
			return true;
		}
	}

}
