 	//1. Keep devided by 2
    public boolean isPowerOfTwo1(int n) {
        if(n <= 0) return false;
        while(n % 2 == 0) n /= 2;
        return n == 1 ? true : false;
    }
    
    //2. Power of 2 means only one bit of n is '1', so use the trick n&(n-1)==0 to judge whether that is the case
    public boolean isPowerOfTwo(int n) {
        return (n > 0) &&  (n & (n - 1)) == 0;
    }