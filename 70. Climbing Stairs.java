    public int climbStairs1(int n) {
        if(n == 1 || n == 2) return n;
        return climbStairs1(n - 1) + climbStairs1(n - 2);//Fibonacci
    }
    
     public int climbStairs(int n) {
        if(n == 0 || n == 1 || n == 2) return n;

        // Array [0, 1, 2, 3, 5 ... ]
        int result = 0, one = 1, two = 2;
        
        for(int i = 2; i < n; i ++){
            result = one + two;
            one = two;
            two = result;
        }
        
        return result;
    }