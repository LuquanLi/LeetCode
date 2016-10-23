 public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses]; //to finish i, need to finish j, j is pre of i
        int[] numReq = new int[numCourses]; //how many courses are pre of i

        for(int i = 0; i < prerequisites.length; i ++){
            int req = prerequisites[i][0];
            int pre = prerequisites[i][1];

            if(matrix[req][pre] == 0) numReq[req] ++; //in case there is duplicate 
            matrix[req][pre] = 1;
        }

        Stack<Integer> stack = new Stack<>();
        int count = 0;//count is how many course can fininsh

        for(int i = 0; i < numCourses; i ++){
            if(numReq[i] == 0) stack.add(i);
        }

        while (!stack.isEmpty()){
            int course = stack.pop();
            count ++;

            for(int i = 0; i < numCourses; i ++){
                if(matrix[i][course] == 1){
                    matrix[i][course] = 0;
                    if(--numReq[i] == 0) stack.add(i);
                }
            }
        }

        return count == numCourses; 
    }