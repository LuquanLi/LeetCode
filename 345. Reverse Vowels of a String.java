    public String reverseVowels(String s) {
        if(s == null || s.length() <= 1) return s;

        StringBuffer sb = new StringBuffer(s);
        int i = 0, j = s.length() - 1;

        while (i < j){
            char ci = sb.charAt(i), cj = sb.charAt(j);
            if(isVowel(ci) && isVowel(cj)){
                swapCharacters(sb, i, j);
                i ++;
                j --;
            }
            if(!isVowel(ci)) i ++;
            if(!isVowel(cj)) j --;
        }

        return sb.toString();
    }

    public boolean isVowel(char c){
        String vowel = "aeiouAEIOU";
        return vowel.indexOf(c) != -1;
    }

    //swap char at i and j in string sb
    public void swapCharacters(StringBuffer sb, int i, int j){
        char c = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, c);
    }