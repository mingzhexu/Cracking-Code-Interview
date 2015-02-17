package unit2;

import java.util.*;

public class Palindrome {
	public boolean isPalindrome(linkedList l){
		Stack<Integer> s = new Stack<Integer>();
		Node current = l.head;
		while(current.next != null){
			s.push(current.value);
			current = current.next;
		}
		s.push(current.value);
		current = l.head;
		while(current.next != null){
			if(current.value != s.pop()){
				//System.out.print(current.value);
				return false;
			}
			current = current.next;
		}
		return true;
	}

}
