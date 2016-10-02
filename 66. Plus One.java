    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) return digits;

        boolean carry = true;
        for(int i = digits.length - 1; i >= 0; i --){
            if(carry && digits[i] + 1 == 10){
                digits[i] = 0;
            }else{
                digits[i] += 1;
                return digits;
            }
        }

        //only for like 99999 + 1
        int[] newdigits = new int[digits.length + 1];
        newdigits[0] = 1;
        return newdigits;
    }