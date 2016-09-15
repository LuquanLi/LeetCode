    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length  < 1 || nums2.length < 1 ) return new int[0];

        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int i = 0; i < nums1.length; i ++){
            int num = nums1[i];
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else {
                map.put(num, 1);
            }
        }

        for(int i = 0; i < nums2.length; i ++){
            int num = nums1[i];
            if(map.containsKey(num)){
                if(map.get(num) >= 1){
                    list.add(num);
                    map.put(num, map.get(num) - 1);
                }
            }
        }

        int[] result = new int[list.size()];
        int count = 0;
        for(Integer in: list){
            result[count++] = in;
        }
        
        return result;
    }