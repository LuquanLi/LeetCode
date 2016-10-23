    public String longestPalindrome(String s) {
        if(s == null || s.length() == 1) return s;
        String max = "";

        for (int i = 0;i < s.length() - 1; i ++){
            String str1 = palindromeLength(i, i , s), str2 = palindromeLength(i, i + 1, s);

            if(str1.length() > str2.length() && str1.length() > max.length()){
                max = str1;
            }else if(str2.length() > str1.length() && str2.length() > max.length()){
                max = str2;
            }
        }

        return max;
    }

    public String palindromeLength(int s1, int s2, String str){
        while (s1 >= 0 && s2 < str.length() && str.charAt(s1) == str.charAt(s2)){
            s1 --;
            s2 ++;
        }
        return str.substring(s1 + 1, s2);
    }