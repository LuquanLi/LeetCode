//136. Single Number

public class Solution {
    //1. Exclusive disjunction or exclusive or is a logical operation that outputs true only when inputs differ
    public int singleNumber1(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++){
            result ^= nums[i];
        }
        return result;
    }

    //2.Create a list to store looped value
    //Time out
    public int singleNumber(int[] nums){
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < nums.length; i ++){
            Integer number = nums[i]; //Should be Integer not int, int will be considered as index
            if(list.contains(number)){
                list.remove(number);
            }else{
                list.add(number);
            }
        }

        return list.get(0);
    }
}