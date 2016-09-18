    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n != 1){
            n = getSquareofDigits(n);
            if(set.contains(n)) return false;
            set.add(n);
        }
        return true;
    }
    
    public int getSquareofDigits(int n){
        int result = 0;
        List<Integer> list = new ArrayList<>();

        while (n > 0){
            list.add(n % 10);
            n = n / 10;
        }

       for(Integer i: list){
           result += i * i;
       }
        return result;
    }