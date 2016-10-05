    public int reverse(int x) {
        boolean isPositive = (x >= 0);
        if(!isPositive) x = -x;

        //if overflow return 0, if 100 -> 1
        int rev = 0;
        while(x > 0){
            //rev * 10 + x / 10 > Max -> rev > (Max - x / 10) / 10;
            if(rev > (Integer.MAX_VALUE - x % 10) / 10) return 0;
            rev = rev * 10 + x % 10;
            x = x / 10;
        }

        return isPositive ? rev : - rev;
    }