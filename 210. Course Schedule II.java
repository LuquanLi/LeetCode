    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0) return new int[0];

        //Initialize
        int[] pre_requisited = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[numCourses];
        int index = 0;

        for(int[] pre: prerequisites){
            if(map.containsKey(pre[1])){
                List<Integer> list = map.get(pre[1]);
                if(!list.contains(pre[0])){
                    list.add(pre[0]);
                    pre_requisited[pre[0]] ++;
                }
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(pre[0]);
                map.put(pre[1], list);
                pre_requisited[pre[0]] ++;
            }
        }

        for(int i = 0; i < numCourses; i ++){
            if(pre_requisited[i] == 0){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()){
            int course = queue.poll();
            result[index++] = course;

            List<Integer> list = map.get(course);
            if(list != null){
                for(int i : list){
                    if( --pre_requisited[i] == 0){
                        queue.add(i);
                    }
                }
            }
        }

        //if there is no available sequence
        for(int i: pre_requisited){
            if(i != 0){
                return new int[0];
            }
        }
        
        return result;
    }