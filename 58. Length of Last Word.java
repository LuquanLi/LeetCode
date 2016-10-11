    public int lengthOfLastWord1(String s) {
        if(s == null || s.length() == 0) return 0;

        //reverse the string, find the first space
        StringBuffer sb = new StringBuffer(s.trim()).reverse();
        int index = sb.indexOf(" ");

        if(index == -1) return s.trim().length();
        return index;
    }
    
    public int lengthOfLastWord(String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ")-1;
    }