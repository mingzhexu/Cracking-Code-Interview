package unit3;
//using stack to write a program to move the disks from the first tower to the last
public class hanoi {
	public static void main(String[] args){
		int n = 3;
		tower[] towers = new tower[n];
		for(int i = 0; i < 3; i++){
			towers[i] = new tower(i);
		}
		for (int i = n-1; i >= 0; n--){
			towers[0].moveDisk(n, towers[2], towers[1]);
		}
	}

}
