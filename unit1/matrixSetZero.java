package unit1;

public class matrixSetZero {
	public void setZero(int[][] m){
		boolean[][] flag = new boolean[m.length][m[0].length];
		for(int i = 0; i<m.length;i++){
			for(int j = 0; j<m[0].length;j++){
				if(m[i][j] == 0){
					flag[i][j] = true;
				}//no need for else -> the DEFAULT value is false.
			}
		}
		for(int i = 0; i < flag.length; i++){
			for(int j = 0; j < flag[0].length; j++){
			    if(flag[i][j]){
			    	for(int p = 0; p < flag[0].length; p++){
			    		m[i][p] = 0;
			    	}
			    	for(int q = 0; q < flag.length; q++){
			    		m[q][j] = 0;
			    	}	
			    }
			}
		}
	}
}
