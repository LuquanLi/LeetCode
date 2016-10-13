    public boolean isSubsequence(String s, String t) {
        if((s == null && t == null) || (s.isEmpty() && t.isEmpty()) || s == null || s.isEmpty()) return true;
        if(t == null || t.isEmpty()) return false;

        int i = 0, j = 0;
        while (j < t.length()){
            if(i == s.length() - 1) return true;
            if(s.charAt(i) == t.charAt(j)) i ++;
            j ++;
        }

        return false;
    }