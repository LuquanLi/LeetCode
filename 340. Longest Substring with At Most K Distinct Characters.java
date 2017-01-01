public int lengthOfLongestSubstringKDistinct1(String s, int k) {
        //Input Validation
        if(s == null || s.equals("") || k == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, result = Integer.MIN_VALUE, tempj = -1;

        while (j < s.length()){

            if(tempj != j){
                Character ch = s.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            if(map.size() < k){
                //continue
                j ++;

                //if string s do not have k distinct characters, return k
                if(j == s.length()) result = s.length();
            }else if (map.size() == k){

                result = Math.max(result, j - i + 1);
                j ++;

            }else{//map.size > k
                //remove the char in i
                Character chi = s.charAt(i);
                if(map.get(chi) == 1){
                    map.remove(chi);
                }else {
                    map.put(chi, map.get(chi) - 1);
                }
                i ++;
                tempj = j;
            }
        }

        return result;
    }
    
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int num = 0, i = 0, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (count[s.charAt(j)]++ == 0) num++;
            if (num > k) {
                while (--count[s.charAt(i++)] > 0);
                num--;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }