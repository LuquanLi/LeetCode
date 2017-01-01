public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result=new ArrayList<Integer>();
        int n=nums.length;
        if(n<1) return result;
        Arrays.sort(nums);
        int[] s=new int[n];
        int[] parent=new int[n]; //used to build result from 
        Arrays.fill(parent,-1);
        s[0]=1;
        int maxSize=0; //largest subset size
        int maxSizelastIndex=0; //the index of largest subset size
        for(int i=1;i<n;i++){
            s[i]=1;
            for(int j=i-1;j>=0;j--){
                if(nums[i]%nums[j]==0){
                    if(s[j]+1>s[i]){
                        s[i]=s[j]+1;
                        parent[i]=j;
                    }
                }
            }
            if(s[i]>maxSize){
                maxSize=s[i];
                maxSizelastIndex=i;
            }
        }
        //populate result;
        int i=maxSizelastIndex;
        while(i>=0){
            result.add(0,nums[i]);
            i=parent[i];
        }
        return result;
    }