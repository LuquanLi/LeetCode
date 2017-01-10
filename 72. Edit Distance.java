    //insert, delete, replace a char
    //min step from word1 to word2
    /*
        1. BFS: huge tree
        2. Compare the difference of word1 and word2
        if word1.len == word2.len
           only need replace. compare char 1 by 1
        if word1.len > word2.len
           delete. which one to delete:
        else
           Add

        3. word1 [****i]   word2 [*****j]
        if word1[i] == word2[j]
        f(i,j) = f (i-1,j-1)
        else
        f(i,j) = 1 + min{f(i,j-1),f(i-1,j),f(i-1,j-1)}

        Base: f(0,k) = f(k,0) = k
     */
    public int minDistance(String word1, String word2) {
        //Input validation
        if(word1 == null || word2 == null) return -1;

        //Matrix initialize
        int m = word1.length(), n = word2.length(), min;
        int[][] cost = new int[m + 1][n + 1];

        for(int i = 1; i <= m; i ++){
            cost[i][0] = i;
        }

        for(int j = 1; j <= n; j ++){
            cost[0][j] = j;
        }

        //Loop through the matrix
        for(int i = 1; i < m + 1; i ++ ){
            for(int j = 1; j < n + 1; j ++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    cost[i][j] = cost[i - 1][j - 1];
                }else{
                    min = Math.min(cost[i - 1][j - 1], Math.min(cost[i - 1][j], cost[i][j - 1]));
                    cost[i][j] = 1 + min;
                }
            }
        }

        return cost[m][n];
    }