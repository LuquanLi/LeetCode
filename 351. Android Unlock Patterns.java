    public int numberOfPatterns(int m, int n) {
        //pass array represents number to pass between two pairs
        //2 -> 9 is OK
        int pass[][] = new int[10][10];
        pass[1][3] = pass[3][1] = 2;
        pass[1][3] = pass[3][1] = 2;
        pass[1][7] = pass[7][1] = 4;
        pass[3][9] = pass[9][3] = 6;
        pass[7][9] = pass[9][7] = 8;
        pass[1][9] = pass[9][1] = pass[2][8] = pass[8][2] = pass[3][7] = pass[7][3] = pass[4][6] = pass[6][4] = 5;

        boolean visited[] = new boolean[10];
        int result = 0;

        for(int i = m; i <= n; i ++){
            result += DFS(visited, pass, 1, i - 1) * 4;
            result += DFS(visited, pass, 2, i - 1) * 4;
            result += DFS(visited, pass, 5, i - 1);
        }

        return result;
    }

    private int DFS (boolean visited[], int[][] pass, int cur, int remain){
        if(remain == 0) return 1;
        visited[cur] = true;
        int result = 0;

        for(int i = 1; i < 10; i ++){
            if(!visited[i] && (pass[cur][i] == 0 || visited[pass[cur][i]])){
                result += DFS(visited, pass, i, remain - 1);
            }
        }
        
        visited[cur] = false;
        return result;
    }