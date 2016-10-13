    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        String[] array = str.split(" ");

        if(array.length != pattern.length()) return false;

        for(int i = 0; i < pattern.length(); i ++){
            char ch = pattern.charAt(i);
            if(!map.containsKey(ch)){
                if(map.containsValue(array[i])) return false;
                map.put(ch, array[i]);
            }else {
                if(!map.get(ch).equals(array[i])) return false;
            }
        }

        return true;
    }