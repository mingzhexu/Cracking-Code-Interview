package unit3;

import java.util.Stack;

public class QueueTwoStacks {
	Stack<Integer> sk1 = new Stack<Integer>();
	Stack<Integer> sk2 = new Stack<Integer>();
	public void enqueue(int value){
		sk1.push(value);
	}
	public int dequeue(){
		if(sk2 == null){
		  while(sk1 != null){
		    sk2.push(sk1.pop());
		  }
		  return sk2.pop();
		}else{
		  return sk2.pop();
		}
	}
	public int size(){
		return sk1.size() + sk2.size();
	}
	
	public void remove(){
		while(sk1 != null){
			sk2.push(sk1.pop());
		}
		sk2.remove(sk2.size() - 1);
		while(sk2!=null){
			sk1.push(sk2.pop());
		}
	}

}
