    public boolean isAnagram(String s, String t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        
        int[] count = new int[26];
        
        for(int i = 0; i < s.length(); i ++){
            count[s.charAt(i) - 'a'] ++;
        }
        
        for(int j = 0; j < t.length(); j ++){
            if(--count[t.charAt(j) - 'a'] < 0) return false;
        }
        
        for(int c: count){
            if(c > 0) return false;
        }
        
        return true;
    }