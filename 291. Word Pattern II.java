public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        return wordPatternMatchHelper(pattern, str, map);
    }

    private boolean wordPatternMatchHelper(String pattern, String str, Map<Character, String> map) {
        if (pattern.length() > str.length() || (pattern.isEmpty() && !str.isEmpty())) return false;
        if (pattern.isEmpty() && str.isEmpty()) return true;

        char ch = pattern.charAt(0);

        for (int i = 0; i < str.length(); i ++) {
            boolean put = false;
            String sub = str.substring(0, i + 1);
            if (!map.containsKey(ch)) {
                if (map.containsValue(sub)) continue;
                map.put(ch, sub);
                put = true;
            }else {
                if (!map.get(ch).equals(sub)) {
                    continue;
                }
            }
            if (wordPatternMatchHelper(pattern.substring(1), str.substring(i+1), map)) {
                return true;
            }
            if(put) map.remove(ch);
        }

        return false;
    }