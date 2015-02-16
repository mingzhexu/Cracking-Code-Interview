package unit3;

//fixed division
public class oneArrayThreeStacks {
	int size = 100;
	int[] arr = new int[size*3];
	int[] pointer = {-1, -1, -1};
	public void push(int stacknum, int value) throws Exception{
		if(pointer[stacknum] + 1 > size){
			throw new Exception("Out of space");
		}
		int index = pointer[stacknum] + stacknum * size;
		arr[index] = value;
		pointer[stacknum]++;
	}
	public int pop(int stacknum) throws Exception{
		if(pointer[stacknum] == -1){
			throw new Exception("This stack is empty.");
		}
		int index = pointer[stacknum] + stacknum*size;
		int v = arr[index];
		arr[index] = 0;
		pointer[stacknum]--;
		return v;
	}

}
