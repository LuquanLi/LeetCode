    public int thirdMax(int[] nums) {
       PriorityQueue<Integer> pq = new PriorityQueue<>();
       Set<Integer> set = new HashSet<>();
       for(int n : nums) {
           if(set.add(n)) {
               pq.offer(n);
               if(pq.size() > 3 ) pq.poll();//the smallest one is the top priority
           }
       }
       if(pq.size() == 2) pq.poll();
       return pq.peek();
    }