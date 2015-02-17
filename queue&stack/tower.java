package unit3;
import java.util.*;
public class tower {
	Stack<Integer> disk ;
	private int index;
	public tower(int i){
		disk = new Stack<Integer>();
		index = i;
	}
	
	public int index(){
		return index;
	}
	
	public void add(int d){
		if(!disk.isEmpty() && disk.peek() <= d){
			System.out.println("Error placing disk " + d);
		}else{
			disk.push(d);
		}
	}
	
	public void moveTopTo(tower t){
		int top = disk.pop();
		t.add(top);
		System.out.println("move disk " + top + " from " + index() + " to " + t.index());
	}
	
	public void moveDisk(int n, tower dest, tower buff){
		if(n > 0){
			moveDisk(n-1, buff, dest);
			moveTopTo(dest);
			buff.moveDisk(n-1, dest, this);
		}
	}

}
