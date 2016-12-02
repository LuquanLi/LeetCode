    //1. copy n elements from nums2 to nums1, sort  -> O(m+n)(log(m+n))
    //2. two pointers, i = 0, j = 0, merge sort. when insert one element, need move all others
    //3. two pointers, i = m - 1, j = n -1   -> sort backwards
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Two pointers at the largest number in each array
        int i = m - 1, j = n - 1, tail = m + n - 1;
        
        //Compare the value and move pointers
        while (i >= 0 && j >= 0){
            if(nums1[i] > nums2[j]){
                nums1[tail--] = nums1[i--];
            }else{
                nums1[tail--] = nums2[j--];
            }
        }
        
        //Copy rest
        while (j >= 0){
            nums1[tail--] = nums2[j--];
        }
    }