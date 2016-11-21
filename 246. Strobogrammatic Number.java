    //00 11 69 88 96
    //check first and last character
    public boolean isStrobogrammatic(String num) {
        if(num == null) return true;
        for(int i = 0, j = num.length() - 1; i <= j; i ++, j --){
            if(!"00 11 69 88 96".contains(num.charAt(i) + "" + num.charAt(j))){
                return false;
            }
        }
        return true;
    }