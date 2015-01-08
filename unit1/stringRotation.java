package unit1;

public class stringRotation {
	public boolean isRotation(String a, String b){
		if(a.length() != b.length()){
			return false;
		}
		if(isSubstring(a+a, b)){
			return true;
		}
		return false;
	}
	
	public boolean isSubstring(String s, String sub){
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == sub.charAt(0)){
				String temp = "";
				for(int j = i; j < i + sub.length(); j++){
					temp = temp + s.charAt(j); 
				}
				if(temp.equals(sub)) return true;
			}
		}
		return false;
	}
	
}
