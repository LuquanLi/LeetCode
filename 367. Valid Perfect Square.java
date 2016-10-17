    public boolean isPerfectSquare1(int num) {
        int start = 1, end = num;

        while (start <= end){
            int mid = (start + end) / 2;
            if(mid * mid == num){
                return true;
            }else if(mid * mid < num){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return false;
    }
    
    //A square number is 1+3+5+7+...
    //1+3+...+(2n-1) = (2n-1 + 1)n/2 = nn
    public boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }