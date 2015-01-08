package unit1;

public class StringCompression {
	public String compress(String s){
		StringBuffer t = new StringBuffer();
		int count = 1;
		char last = s.charAt(0);
		for(int i = 1; i < s.length(); i++){
			if(s.charAt(i) != last){
				t.append(last);
				t.append(count);
				count = 1;
				last = s.charAt(i);
			}else{
				count++;
				last = s.charAt(i);
			}
		}
		return t.toString() + last + count;
	}

}
