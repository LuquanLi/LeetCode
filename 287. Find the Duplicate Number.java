    //extra space, set/array...
    //we only need to konow who is the duplicate one, not where is the dupe
    //num: 1 - n
    //suppose: 1 - 9 : 4 nums < 5, 4 nums > 5 ; if there are > 4 nums < 5, the dupe is in there
    public int findDuplicate(int[] nums) {
        int n=nums.length-1;
        int left=0, right=n;
        while(left<right){
            int mid=left+(right-left)/2;
            int count=numBelow(nums, mid);
            if(count>mid) right=mid;
            else left=mid+1;
        }
        return left;
    }
    public int numBelow(int[] nums, int target){
        int result=0;
        for(int i=0; i<nums.length; i++)
            if(nums[i]<=target) result++;
        return result;
    }