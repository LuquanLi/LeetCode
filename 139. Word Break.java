    //time out
    public boolean wordBreak1(String s, Set<String> wordDict) {
        if(s.isEmpty()) return true;
        boolean result = false;

        for(int i = 0; i < s.length(); i ++){
            if(wordDict.contains(s.substring(0, i + 1))){
                result = wordBreak(s.substring(i + 1), wordDict);
                if(result) return result;
            }
        }

        return result;
    }
    
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] result = new boolean[s.length() + 1];
        result[0] = true;

        for (int i = 0; i < s.length(); i ++){
            if(!result[i]) continue;
            for (int j = i; j < s.length() + 1; j ++){
                if(wordDict.contains(s.substring(i, j))) result[j] = true;
            }
        }

        return result[s.length()];
    }