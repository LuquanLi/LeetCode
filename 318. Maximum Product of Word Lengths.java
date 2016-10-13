    public int maxProduct1(String[] words) {
        if(words == null || words.length <= 1) return 0;

        int max = 0;

        for (int i = 0; i < words.length - 1; i ++){
            for (int j = i + 1; j < words.length; j ++){
                if(isExcusive(words[i], words[j])){
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }

    private boolean isExcusive(String s, String t){
        
        for (int i = 0; i < s.length(); i ++){
            for(int j = 0; j < t.length(); j ++){
                if(s.charAt(i) == t.charAt(j)) return false;
            }
        }

        return true;
    }
    
    public static int maxProduct(String[] words) {
    	if (words == null || words.length <= 1) return 0;
    	
    	int len = words.length;
    	int[] value = new int[len];
    	
    	//switch char to number a -> 0 (0000), b -> 1 (0001), c -> 2 (0010), d -> 3 (0011), e -> 4 (0100)
        // 1 << 1往左移几位, 用bit来表示字母: ex:abc 000..000111  , adf 000..0010101
        // & == 0 就是都不一样, 有 1 的 不等于 0 就是有一样的
    	for (int i = 0; i < len; i++) {
    		String tmp = words[i];
    		value[i] = 0;
    		for (int j = 0; j < tmp.length(); j++) {
    			value[i] |= 1 << (tmp.charAt(j) - 'a');
    		}
    	}
    	int maxProduct = 0;
    	for (int i = 0; i < len; i++)
    		for (int j = i + 1; j < len; j++) {
    			if ((value[i] & value[j]) == 0 && (words[i].length() * words[j].length() > maxProduct))
    				maxProduct = words[i].length() * words[j].length();
    		}
    	return maxProduct;
    }