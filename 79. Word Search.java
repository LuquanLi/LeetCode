    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0) return true;
        if(board == null || board.length == 0) return false;

        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[i].length; j ++){
                if(board[i][j] == word.charAt(0)){
                    if(search(board, word, i, j)) return true;
                }
            }
        }

        return false;
    }

    public boolean search(char[][] board, String word, int i, int j){
        if(word.equals("")) return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length) return false;

        boolean result = false;
        char c = board[i][j];
        
        if(board[i][j] == word.charAt(0)){
            board[i][j] = '*';
            result = search(board, word.substring(1), i + 1, j) ||
                    search(board, word.substring(1), i - 1, j) ||
                    search(board, word.substring(1), i, j + 1) ||
                    search(board, word.substring(1), i, j - 1);
        }
        
        board[i][j] = c;//注意要改回来
        return result;
    }