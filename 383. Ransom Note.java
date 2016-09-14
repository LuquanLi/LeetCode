    //1. Hashmap
    public boolean canConstruct1(String ransomNote, String magazine) {
        if(ransomNote == null || (ransomNote == null && magazine == null)) return true;
        if(magazine == null && (ransomNote != null || ransomNote.length() > 0)) return false;

        Map<Character,Integer> map = new HashMap<>();
        
        for(int i = 0; i < magazine.length(); i ++){
            char ch = magazine.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) + 1);
            }else{
                map.put(ch, 1);
            }
        }
        
        for(int j = 0; j < ransomNote.length(); j ++){
            char ch = ransomNote.charAt(j);
            if(map.containsKey(ch) && map.get(ch) >= 1){
                map.put(ch, map.get(ch) - 1);
            }else{
                return false;
            }
        }
        
        return true;
    }
    
    //2. Array
     public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
           
            if(--arr[ransomNote.charAt(i)-'a'] < 0) {
                return false;
            }
        }
        return true;
    }