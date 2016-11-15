    public String longestCommonPrefix(String[] strs) {
        if(strs == null) return null;
        if(strs.length == 0) return "";

        String prefix = strs[0];
        for(int i = 1; i < strs.length; i ++){
            //When strs[i].indexOF(prefix) == 0, like "abcde".indexOf("abc") == 0
            while (strs[i].indexOf(prefix) != 0){
                //shrink the size of prefix
                prefix = prefix.substring(0, prefix.length() - 1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }