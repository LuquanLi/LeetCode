    //the largest number is largest first digit, find the number with largest first/second/third digit, put at first, then find second one...
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return "";

        String[] snums = new String[nums.length];
        for(int i = 0; i < nums.length; i ++){
            snums[i] = nums[i] + "";
        }

        Comparator<String> comparator = new Comparator<String>() {
            @Override public int compare(String str1, String str2) {
                //1. compare digit by digit
                //2.
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s2.compareTo(s1);
            }
        };

        Arrays.sort(snums, comparator);

        if(snums[0].charAt(0) == '0') return "0"; //all 0

        StringBuffer sb = new StringBuffer();
        for(String str: snums){
            sb.append(str);
        }

        return sb.toString();
    }

    //Java 8
    public String largestNumber2(int[] num) {
        String[] array = Arrays.stream(num).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(array, (String s1, String s2) -> (s2 + s1).compareTo(s1 + s2));
        return Arrays.stream(array).reduce((x, y) -> x.equals("0") ? y : x + y).get();
    }