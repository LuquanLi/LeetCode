 public static boolean validWordAbbreviation(String word, String abbr) {
        if(abbr == null || abbr.length() > word.length()) return false;

        int i = 0, j = 0, start = 0;
        while (i < abbr.length() && j < word.length()){
            //consider w12d -> twelve
            start = i;
            while (i < abbr.length() && Character.isDigit(abbr.charAt(i))){
                i ++;
            }
            if(!abbr.substring(start, i).equals("")){
                if(abbr.substring(start, i).charAt(0) == '0') return false;
                j += Integer.valueOf(abbr.substring(start, i));
            }

            if(i >= abbr.length() || j >= word.length()) break;
            if(abbr.charAt(i) != word.charAt(j)) return false;
            j ++;
            i ++;
        }

        return word.length() == j && abbr.length() == i;
    }