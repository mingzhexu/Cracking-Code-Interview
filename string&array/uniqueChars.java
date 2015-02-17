package unit1;

public class uniqueChars {
	public static void main(String[] args){
		System.out.print(isunique("abcdde"));
	}
	public static boolean isunique(String s){
		for(int i = 0; i < s.length(); i++){
			char a = s.charAt(i);
			for(int j = i + 1; j < s.length(); j++){
				if(a == s.charAt(j)){
					return false;
				}
			}
		}
		return true;
	}
	

}
