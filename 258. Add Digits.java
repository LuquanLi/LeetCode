    //1. Recursive add digit
    public int addDigits1(int num) {
        int result = 0;

        while(num > 0){
            result += num % 10;
            num /= 10;
        }

        if(result < 10) return result;
        else return addDigits(result);
    }
    
    //2. Find the pattern
    /*
    0 - 0
    ...
    9 - 9
    10 - 1
    11 - 2
    12 - 3
    ...
    18 - 9
    19 - 1
    ...
    */
    public int addDigits(int num) {
        if(num == 0) return 0;
        return num % 9 == 0 ? 9 : num % 9;
    }