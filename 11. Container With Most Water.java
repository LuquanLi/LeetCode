//For point (i,ai) and (j,aj), the water contains: (j - i) * min(ai, aj)
    /* 1. Brute force  O(n2)
        int max = 0;
        for(int i = 0; i < len - 1; i ++){
            for(int j = i + 1; j < len; j ++{
                calculate water and update max
            }
        }
    */
    /* we can not sort
       the water is depends on min height and width
       for point(i,ai), if he is the left edge, the most water he can get is the most right point whom is higher than ai
       jia bi ...
       start from most left and right edge, move the shorter one, update max.
     */
    public int maxArea(int[] height) {
        //check input validation
        if(height == null || height.length == 0) return 0;

        //initialize variable: max water, left edge, right edge
        int max = 0, water, left = 0, right = height.length - 1;

        while (left < right){
            //calculate water and update max
            water = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, water);

            //move the shorter edge
            if(height[left] <= height[right]){
                left ++;
            }else{
                right --;
            }
        }

        return max;
    }