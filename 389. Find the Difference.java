    // 1 . Hashmap
    public char findTheDifference1(String s, String t) {
        if(s == null || s .equals("")) return t.charAt(0);

        Map<Character, Integer> map = new HashMap<>();
        char[] array = s.toCharArray();

        //Loop string s
        for(int i = 0; i < s.length(); i ++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) + 1);
            }else{
                map.put(ch, 1);
            }
        }

        //Loop string t
        for(int i = 0; i < t.length(); i ++){
            char ch = t.charAt(i);
            if(map.containsKey(ch) && map.get(ch) >= 1){
                map.put(ch, map.get(ch) - 1);
            }else{
               return ch;
            }
        }

        return 'a';
    }
    
    // 2. XOR 
    public char findTheDifference(String s, String t) {
        if(s == null || s .equals("")) return t.charAt(0);
        
        char result = '\0';

        for(int i = 0; i < s.length(); i ++){
            result ^= s.charAt(i);
        }

        for(int j = 0; j < t.length(); j ++){
            result ^= t.charAt(j);
        }
        return result;
    }