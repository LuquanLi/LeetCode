    //1. int to String, compare each pair of char (last and first)
    //2. similiar to 1st one, loop the number knowing how many digit, loop (compare first and last digit)
    
    //3. seperate the int into half, reverse the second half
    //if even digits: 123321 -> 123 = (321).reverse = 123
    //if odd digits: 12321 -> 12 = (321).reverse / 10 = 12
    public boolean isPalindrome(int x) {
        if(x < 0 || (x != 0 && x % 10 == 0)) return false;
        
        int rev = 0;
        while(x > rev){
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        
        return (x == rev || x == rev / 10);
    }