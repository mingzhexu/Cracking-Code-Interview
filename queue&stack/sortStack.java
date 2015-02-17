package unit3;

import java.util.Stack;

public class sortStack {
	//can only use another stack; no other data structures are allowed
	public Stack<Integer> sortStack(Stack<Integer> sk){
		Stack<Integer> sk1 = new Stack<Integer>();
		if(sk.isEmpty()) return null;
		while(!sk.isEmpty()){
			if(sk1.isEmpty()){
				sk1.push(sk.pop());
			}
			int temp = sk.pop();
			if(temp > sk1.peek()){
				sk1.push(temp);
			}else{
				sk.push(sk1.pop());
			}
		}
		return sk1;
	}

}
