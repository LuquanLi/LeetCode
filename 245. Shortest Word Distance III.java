public int shortestWordDistance(String[] words, String word1, String word2) {
        if(words == null || words.length <= 1) return 0;
        int min = Integer.MAX_VALUE, i = -1, j = -1;

        for(int k = 0; k < words.length; k ++){
            if(word1.equals(word2) && words[k].equals(word1)){ //word1 equals word2
                i = j;
                j = k;
            }else{//word1 not equals word2
                if(words[k].equals(word1)) i = k;
                if(words[k].equals(word2)) j = k;
            }
            if(i != -1 && j != -1){
                min = Math.min(min, Math.abs(i - j));
            }
        }
        
        ret