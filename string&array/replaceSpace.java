package unit1;

public class replaceSpace {
	public String replace(String s){
	    int l = s.length() + 2 * count(s);
		char[] arr = new char[l];
		int t = l - 1;
		for(int i = s.length() - 1; i >= 0; i--){
			if(s.charAt(i) == ' '){
				arr[t] = '0';
				arr[t-1] = '2';
				arr[t-2] = '%';
				t = t-3;
			}else{
				arr[t] = s.charAt(i);
				t = t-1;
			}
		}
		return new String(arr);
	}
	public int count(String s){
		int n = 0;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) ==  ' '){
				n++;
			}
				
		}
		return n;
	}

}
