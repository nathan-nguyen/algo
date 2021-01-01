class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) return;
	
	boolean frow = false, fcol = false;

	for (int i = 0; i < matrix.length; ++i){
		for (int j = 0; j < matrix[0].length; ++j){
			if (matrix[i][j] != 0) continue;
			if (i == 0) frow = true;
			else matrix[i][0] = 0;
			if (j == 0) fcol = true;
			else matrix[0][j] = 0;
		}
	}

	for (int i = 1; i < matrix.length; ++i){
                for (int j = 1; j < matrix[0].length; ++j){
                	if ((i == 0 && frow) || (j == 0 && fcol) || matrix[0][j] == 0 || matrix[i][0] == 0) matrix[i][j] = 0;
        	}
        }

	if (frow) for (int i = 0; i < matrix[0].length; ++i) matrix[0][i] = 0;
    	if (fcol) for (int i = 0; i < matrix.length; ++i) matrix[i][0] = 0;
    }
}
