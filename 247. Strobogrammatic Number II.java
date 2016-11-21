    String[] strobo = {"00", "11", "69", "88", "96"};
    //010 not ok
    //but we need keep 010 when n = 5 so we can have 10101
    public List<String> findStrobogrammatic(int n) {
        return findStrobogrammatic(n ,n);
    }

    public List<String> findStrobogrammatic(int cur, int n) {
        List<String> result = new ArrayList<>();
        if(cur == 0){
            result.add("");
            return result;
        }
        if(cur == 1){
            result.add("0");
            result.add("1");
            result.add("8");
            return result;
        }

        for(String str: findStrobogrammatic(cur - 2, n)){
            for(String sto: strobo){
                if(sto.charAt(0) == '0' && cur == n) continue;
                result.add(sto.charAt(0) + str + sto.charAt(1));
            }
        }
        return result;
    }