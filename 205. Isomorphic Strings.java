 //Two maps
    public boolean isIsomorphic(String s, String t) {
         //Input validation
        if(s == null && t == null) return true;
        if(s == null || t == null || s.length() != t.length()) return false;

        Map<Character, Character> mapS = new HashMap<>(), mapT = new HashMap<>();

        for(int i = 0; i < s.length(); i ++){
            char cs = s.charAt(i), ct = t.charAt(i);

            if(mapS.containsKey(cs) && mapS.get(cs) != ct) return false;
            if(mapT.containsKey(ct) && mapT.get(ct) != cs) return false;

            mapS.put(cs, ct);
            mapT.put(ct, cs);
        }

        return true;
    }
    
    public boolean isIsomorphic2(String s, String t) {
       //1 map: https://discuss.leetcode.com/topic/14158/java-solution-using-hashmap
       //2. two arrays: https://discuss.leetcode.com/topic/12981/my-6-lines-solution/9
       return true;
    }