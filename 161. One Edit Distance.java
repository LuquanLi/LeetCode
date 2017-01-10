    public boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null) return false;
        if(Math.abs(s.length() - t.length()) > 1 || (s.equals(t))) return false;

        for(int i = 0; i < Math.min(s.length(), t.length()); i ++){
            if(s.charAt(i) != t.charAt(i)){
                if(s.length() == t.length()){
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else if(s.length() > t.length()){
                    return s.substring(i + 1).equals(t.substring(i));
                }else {
                    return t.substring(i + 1).equals(s.substring(i));
                }
            }
        }

        return true;
    }