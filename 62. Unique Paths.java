 public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];

        //mark up and left edge to 1
        for(int i = 0; i < m; i ++){
            matrix[i][0] = 1;
        }

        for(int j = 0; j < n; j ++){
            matrix[0][j] = 1;
        }

        //for others, = up + left
        for(int i = 1; i < m; i ++){
            for(int j = 1; j < n; j ++){
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
            }
        }

        return matrix[m - 1][n - 1];
    }
    
    //Back track: time out
    public int uniquePaths2(int m, int n) {
        return backtrack(0, 0, m, n);
    }

    private int backtrack(int row, int col, int m, int n) {
        // to the target
        if(row == m - 1 && col == n - 1)
            return 1;
        // out of range
        if(row > m - 1 || col > n - 1)
            return 0;

        // move down + move right
        return backtrack(row + 1, col, m, n) + backtrack(row, col + 1, m, n);
    }
    
    public int uniquePaths3(int m, int n){
        if(m == 1 || n == 1) return 1;
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }