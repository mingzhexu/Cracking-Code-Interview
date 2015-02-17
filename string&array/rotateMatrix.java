package unit1;

public class rotateMatrix {
	public void rotate(int[][] m){
		int nrow = m.length;
		for(int i = 0; i < nrow/2; i++){//traverse columns
			int n = nrow - 2*i - 1;//rotate number
			for(int j = i; j < nrow - i - 1; j++){//traverser rows
				int top = m[j][i];
				m[j][i] = m[i+n][j];
				m[i+n][j] = m[n-j][i+n];
				m[n-j][i+n] = m[i][n-j];
				m[i][n-j] = top;
			}
		}
	}

}
