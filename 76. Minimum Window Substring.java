 public String minWindow(String s, String t) {
        //Input validation
        if(s == null || t == null) return "";

        Map<Character, Integer> mapT = new HashMap<>();
        String minWindow = "";
        int count = t.length(), i = 0, j = 0, tempj = -1;

        //map string t to mapT
        for(int k = 0; k < t.length(); k ++){
            mapT.put(t.charAt(k), mapT.getOrDefault(t.charAt(k), 0) + 1);
        }

        //index i and j as sliding window
        while (j < s.length()) {
            Character ch = s.charAt(j);

            //if mapT contains this char, update map and count, if do not contains, let it go
            if(mapT.containsKey(ch) && tempj != j){ //j is not move this time, so, do not add it again
                mapT.put(ch, mapT.get(ch) - 1);
                if(mapT.get(ch) >= 0) count --;
            }

            //t contains in window
            if(count == 0){
                String window = s.substring(i, j + 1);

                //update min window
                if(minWindow.equals("") || minWindow.length() > window.length()){
                    minWindow = window;
                }

                //move index i
                Character ch2 = s.charAt(i);
                if(mapT.containsKey(ch2)){
                    mapT.put(ch2, mapT.get(ch2) + 1);
                    if(mapT.get(ch2) > 0) count ++;
                }
                i ++;
                tempj = j;
                
            }else {
                j ++;
            }

        }

        return minWindow;
    }