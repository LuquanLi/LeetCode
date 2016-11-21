    //What about null, "", "a"
    public boolean repeatedSubstringPattern(String str) {
        if(str == null || str.length() <= 1) return false;

        char start = str.charAt(0);
        for(int i = 1; i < str.length(); i ++){
            if(str.charAt(i) == start && checkPattern(str, str.substring(0, i))){
                return true;
            }
        }

        return false;
    }

    //"abc" * 3 = "abcabcabc";
    private boolean checkPattern(String str, String pattern){
        int size = str.length() / pattern.length();
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < size; i ++){
            sb.append(pattern);
        }

        return str.equals(sb.toString());
    }