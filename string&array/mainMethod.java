package unit1;

public class mainMethod {
	
	public static void main(String[] args){
		//isPermutation p = new isPermutation();
		//System.out.print(p.permutationv2("aaabbde", "aaabbde"));
		
		//replaceSpace r = new replaceSpace();
		//System.out.print(r.replace("I AM MAGGIE"));
		
		//StringCompression sp = new StringCompression();
		//System.out.print(sp.compress("aaannbbbdeee"));
		
		/*int[][] matrix = {
	   			  { 1, 2, 3 },
				  { 4, 0, 6 },
				  { 7, 8, 9 }
				};
		rotateMatrix rm = new rotateMatrix();
		rm.rotate(matrix);
		for(int i = 0; i<matrix.length; i++){
			for(int j = 0; j < matrix.length; j++){
				System.out.print(matrix[i][j]);
			}
			System.out.print("\n");
		}
		System.out.print("\n");
		matrixSetZero msz = new matrixSetZero();
		msz.setZero(matrix);
		for(int i = 0; i<matrix.length; i++){
			for(int j = 0; j < matrix.length; j++){
				System.out.print(matrix[i][j]);
			}
			System.out.print("\n");
		}*/
		
		stringRotation sr = new stringRotation();
		System.out.print(sr.isSubstring("absence", "abs"));
		System.out.print(sr.isRotation("stackoverflow", "overflowstack"));
	}

}
