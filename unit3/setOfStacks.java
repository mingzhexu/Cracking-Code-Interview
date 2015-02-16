package unit3;
import java.util.*;
public class setOfStacks {
	ArrayList<Stack> StackSet = new ArrayList<Stack>();
	int capacity = 100;
	public void push(int value){
		Stack<Integer> last = getLast(StackSet);
		if(last != null && !isFull(last)){
			last.push(value);
		}else{
			Stack<Integer> stack = new Stack<Integer>();
			stack.push(value);
			StackSet.add(stack);
		}
	}
	public int pop(){
		Stack<Integer> last = getLast(StackSet);
		int v = last.pop();
		if(last.isEmpty()){
			StackSet.remove(StackSet.size() - 1);
		}
		return v;
		
	}
	public Stack<Integer> getLast(ArrayList<Stack> stackSet2){
		int index = stackSet2.size() - 1;
		Stack<Integer> last = stackSet2.get(index);
		return last;
	}
	public boolean isFull(Stack<Integer> s){
		if(s.size() >= 100){
			return true;
		}
		return false;
	}
	

}
