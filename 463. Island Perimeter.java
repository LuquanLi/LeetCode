    public int islandPerimeter(int[][] grid) {
        //Input validation
        if(grid == null || grid.length == 0) return 0;

        //count number of 1's and number of neighbours
        int count = 0, countN = 0;

        //Loop through grid
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[i].length; j ++){
                if(grid[i][j] == 1){
                    count ++;
                    countN += getNumofNeighbours(grid, i, j);
                }
            }
        }

        return count * 4 - countN;
    }

    private int getNumofNeighbours(int[][] grid, int i, int j){
        int count = 0;

        if(i - 1 >= 0) count += grid[i - 1][j];
        if(j - 1 >= 0) count += grid[i][j - 1];
        if(i + 1 < grid.length) count += grid[i + 1][j];
        if(j + 1 < grid[i].length) count += grid[i][j + 1];

        return count;
    }
    
    /*
    1. loop over the matrix and count the number of islands;
    2. if the current dot is an island, count if it has any right neighbour or down neighbour;
    3. the result is islands * 4 - neighbours * 2

    public int islandPerimeter(int[][] grid) {
        int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                }
            }
        }

        return islands * 4 - neighbours * 2;
    }
    
    */