 public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0) return 0;

        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] result = new int[m][n];

        boolean block = false;
        for(int i = 0; i < m; i ++){
            if(obstacleGrid[i][0] == 1) block = true;
            result[i][0] = block ? 0 : 1;
        }

        block = false;
        for(int j = 0; j < n; j ++){
            if(obstacleGrid[0][j] == 1) block = true;
            result[0][j] = block ? 0 : 1;
        }

        for(int i = 1; i < m; i ++){
            for(int j = 1; j < n; j ++){
                if(obstacleGrid[i][j] == 1){
                    result[i][j] = 0;
                }else{
                    result[i][j] = result[i - 1][j] + result[i][j - 1];
                }
            }
        }

        return result[m - 1][n - 1];
    }