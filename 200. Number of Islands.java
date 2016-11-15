    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        int count = 0;
        
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[i].length; j ++){
                if(grid[i][j] == '1'){
                    markIsland(grid, i, j);
                    count ++;
                }
            }
        }
        
        return count;
    }
    
    public void markIsland(char[][] grid, int i, int j){
        if(i < 0 || i > grid.length - 1 || j < 0 || j > grid[i].length - 1 || grid[i][j] == '0') return;
        grid[i][j] = '0';
        markIsland(grid, i - 1, j);
        markIsland(grid, i + 1, j);
        markIsland(grid, i, j - 1);
        markIsland(grid, i, j + 1);
    }