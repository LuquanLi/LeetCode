
    Map<String, List<Integer>> map = new HashMap<>();
    public WordDistance(String[] words) {
        for(int i = 0; i < words.length; i ++){
            if(map.containsKey(words[i])){
                map.get(words[i]).add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(words[i], list);
            }
        }
    }

//call shortest many times, require less time
    public int shortest(String word1, String word2) {
        if(word1.equals(word2)) return 0;
        List<Integer> list1 = map.get(word1), list2 = map.get(word2);
        if(list1 == null || list2 == null) return -1;

        int min = Integer.MAX_VALUE;
        for(Integer i : list1){
            for(Integer j : list2){
                min = Math.min(min, Math.abs(i - j));
            }
        }

        return min;
    }

    /* every time it will loop once
    String[] words;
    public WordDistance(String[] words) {
        this.words =words;
    }

    public int shortest(String word1, String word2) {
        if(word1.equals(word2)) return 0;
        int min = Integer.MAX_VALUE, i = -1, j = -1;

        for(int k = 0; k < this.words.length; k ++){
            if(this.words[k].equals(word1)) i = k;
            if(this.words[k].equals(word2)) j = k;

            if(i != -1 && j != -1){
                min = Math.min(min, Math.abs(i - j));
            }
        }

        return min;
    }
    */