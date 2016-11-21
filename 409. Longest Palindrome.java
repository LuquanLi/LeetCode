    public int longestPalindrome1(String s) {
        if(s == null || s.length() == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else{
                map.put(c, 1);
            }
        }

        int even = 0, odd = 0, value = 0;
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() % 2 == 0){
                even += entry.getValue();
            }else if(entry.getValue() != 1){
                even += entry.getValue() - 1;
                odd = 1;                     //"cccccc"
            }else {
                odd = 1;
            }
        }

        return even + odd;
    }
    
    public int longestPalindrome(String s) {
        if(s==null || s.length()==0) return 0;
        HashSet<Character> hs = new HashSet<Character>();
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(hs.contains(s.charAt(i))){
                hs.remove(s.charAt(i));
                count++;
            }else{
                hs.add(s.charAt(i));
            }
        }
        return count*2 + (hs.isEmpty() ? 0 : 1);
    }