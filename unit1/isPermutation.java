package unit1;

import java.util.Arrays;

public class isPermutation {
	
	public boolean permutation(String a, String b){
		if(a.length() != b.length()){
			return false;
		}
		return sortarr(a).equals(sortarr(b));
	}
	private String sortarr(String s){
		char[] a = s.toCharArray();
		Arrays.sort(a);
		//System.out.print(a);
		return new String(a);
	}
	
	//without sorting
	//the key of permutation is that two strings are anagrams, 
	//where they have to same amount of every character.
	  // first check if they have the same length
	  // then check if there are more more letters in one than other
	public boolean permutationv2(String a, String b){
		if(a.length() != b.length()){
			return false;
		}
		
		int[] content = new int[256];
		
		char[] arr1 = a.toCharArray();
		
		for(char s : arr1){
			content[s]++;
		}
		
		for(int i = 0; i < b.length(); i++){
			int x = (int) b.charAt(i);
			if(--content[x] < 0) return false;
			//check if there is more letter in the second word, given same length
		}
		
		return true;
	}
	

}
