package unit3;
import java.util.*;
public class trackMin extends Stack<Integer>{
	//pop, push and min should all take O(1) TIME.
	Stack<Integer> s;
	public trackMin(){
		s = new Stack<Integer>();
	}
	
	public void push(int value){
		if(value <= min()){
			s.push(value);
		}
		super.push(value);//what is super??
	}
	
	public Integer pop(){
		int value = super.pop();
		if(value == min()){
			s.pop();
		}
		return value;
	}
	
	public int min(){
		if(s.isEmpty()){
			return Integer.MAX_VALUE;		
		}else{
			return s.peek();
		}
	}
	
	

}
