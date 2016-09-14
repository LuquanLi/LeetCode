    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length < 1 || nums2.length < 1) return new int[0];

        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int i = 0; i < nums1.length; i ++){
            set.add(nums1[i]);
        }

        for(int j = 0 ; j < nums2.length; j ++){
            if(set.contains(nums2[j])) set2.add(nums2[j]);
        }

        int[] result = new int[set2.size()];
        int count = 0;
        
        for(Integer k: set2){
            result[count ++] = k;
        }
        
        return result;
    }