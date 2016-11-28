public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if(strs == null || strs.length == 0) return result;

        Map<String, List<String>> map = new HashMap<>();
        
        for(String str: strs){
            char[] arr =  str.toCharArray();
            Arrays.sort(arr);
            String newStr = String.valueOf(arr);
            
            if(map.containsKey(newStr)){
                map.get(newStr).add(str);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(newStr, list);
            }
        }
        
        for(List<String> list : map.values()){
            result.add(list);
        }
        
        return result;
    }