public List<Integer> topKFrequent1(int[] nums, int k) {
        //Count the freq of each element -> map<num, count>
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            //This is a Java 8 method
            //getOrDefault(Object key, V defaultValue): Returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key.
            map.put(n, map.getOrDefault(n,0)+1);
        }

        //Priority queue sort by count
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a,b)->(b.getValue()-a.getValue())); //a, b is entry in map
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            maxHeap.add(entry);
        }

        //Pop the element from pq to list
        List<Integer> res = new ArrayList<>();
        while(res.size()<k){
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }
        return res;
    }
    
    // use an array to save numbers into different bucket whose index is the frequency
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        
        // corner case: if there is only one number in nums, we need the bucket has index 1.
        List<Integer>[] bucket = new List[nums.length+1]; //index 1 to len
        for(int n:map.keySet()){
            int freq = map.get(n);
            if(bucket[freq]==null){
                bucket[freq] = new LinkedList<>();
            }
            bucket[freq].add(n);
        }
        
        List<Integer> res = new LinkedList<>();
        for(int i=bucket.length-1; i>0 && k>0; --i){
            if(bucket[i]!=null){
                List<Integer> list = bucket[i]; 
                res.addAll(list);
                k-= list.size();
            }
        }
        
        return res;
    }