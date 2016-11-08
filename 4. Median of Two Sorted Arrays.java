 //https://discuss.leetcode.com/topic/4996/share-my-o-log-min-m-n-solution-with-explanation/2
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         //get the length of nums1 and nums2
        int m = nums1.length, n = nums2.length;
        if(m > n) return findMedianSortedArrays(nums2, nums1);

        //set value of i
        int imin = 0, imax = m,i=0,j=0, half = (m + n + 1) / 2, max_of_left=0, min_of_right=0;

        while (imin <= imax){
            i = (imin + imax) / 2;
            j = half - i;

            if(i < m && nums2[j - 1] > nums1[i]){
                imin = i + 1;
            }else if (i > 0 && nums1[i - 1] > nums2[j]){
                imax = i - 1;
            }else{
                if( i == 0){
                    max_of_left = nums2[j - 1];
                }else if(j == 0){
                    max_of_left = nums1[i - 1];
                }else {
                    max_of_left = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                break;
            }
        }

        if((m + n) % 2 == 1) return max_of_left;

        if(i == m){
            min_of_right = nums2[j];
        }else if(j == n){
            min_of_right = nums1[i];
        }else {
            min_of_right = Math.min(nums1[i], nums2[j]);
        }

        return (max_of_left + min_of_right) / 2.0;
    }