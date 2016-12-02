    //Time out
    public int minPathSum1(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        return minPathSum(grid, m - 1, n - 1);
    }

    //i, j represent destination
    private int minPathSum(int[][] grid, int i, int j){
        int sum = 0;

        if(i == 0){
            for(int k = 0; k <= j; k ++){
                sum += grid[i][k];
            }
            return sum;
        }

        if(j == 0){
            for(int k = 0; k <= i; k ++){
                sum += grid[k][j];
            }
            return sum;
        }

        return Math.min(minPathSum(grid, i - 1, j), minPathSum(grid, i, j - 1)) + grid[i][j];
    }

    
    public int minPathSum(int[][] grid) {
    	int m = grid.length;// row
    	int n = grid[0].length; // column
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
    			if (i == 0 && j != 0) {
    				grid[i][j] = grid[i][j] + grid[i][j - 1];
    			} else if (i != 0 && j == 0) {
    				grid[i][j] = grid[i][j] + grid[i - 1][j];
    			} else if (i == 0 && j == 0) {
    				grid[i][j] = grid[i][j];
    			} else {
    				grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j])
    						+ grid[i][j];
    			}
    		}
    	}
    
    	return grid[m - 1][n - 1];
    }