 //1, bfs
    /*String[] strobo = {"00", "11", "69", "88", "96"};

    public int strobogrammaticInRange(String low, String high) {
        List<String> list = new ArrayList<>();
        int count = 0;

        for(int i = low.length(); i <=  high.length(); i ++){
            list = findStrobogrammatic(i, i);
            for(String str: list){
                if(low.length() == high.length()){
                    if(str.compareTo(low) >= 0 && str.compareTo(high) <=0 ) count++;
                }else{
                    if(i == low.length() && str.compareTo(low) >= 0) || (i > low.length() && i < high.length()) || (i == high.length() && str.compareTo(high) <= 0))  count ++;
                }
            }
        }

        return count;
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
    }*/
    
    //2.dfs
    private static final char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};

    public int strobogrammaticInRange(String low, String high) {
        int[] count = {0};
        for (int len = low.length(); len <= high.length(); len++) {
            char[] c = new char[len];
            dfs(low, high, c, 0, len - 1, count);
        }
        return count[0];
    }

    public void dfs(String low, String high , char[] c, int left, int right, int[] count) {
        if (left > right) {
            String s = new String(c);
            if ((s.length() == low.length() && s.compareTo(low) < 0) || 
                (s.length() == high.length() && s.compareTo(high) > 0)) {
                return;
            }
            count[0]++;
            return;
        }
        for (char[] p : pairs) {
            c[left] = p[0];
            c[right] = p[1];
            if (c.length != 1 && c[0] == '0') {
                continue;
            }
            if (left == right && p[0] != p[1]) {
                continue;
            }
            dfs(low, high, c, left + 1, right - 1, count);
        }
    }