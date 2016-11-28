    //1. https://leetcode.com/problems/palindrome-partitioning/
    //get all combinations and find the one with min len
    /*public int minCut(String s) {
        int[] min = {Integer.MAX_VALUE};
        partition(s, new ArrayList<String>(), min);
        return min[0];
    }

    public void partition(String str, List<String> list,int[] min){
        if(str.equals("")){
            if(list.size() > 0){
                min[0] = Math.min(min[0], list.size() - 1); 
            }
            return;
        }

        for(int i = 0; i < str.length(); i ++){
            if(isPalindrome(str.substring(0, i + 1))){
                List<String> temp = new ArrayList<>(list);
                temp.add(str.substring(0, i + 1));
                partition(str.substring(i + 1), temp, min);
            }
        }
    }

    public boolean isPalindrome(String s){
        if(s == null || s.length() <= 1) return true;
        int head = 0, tail = s.length() - 1;
        while(head <= tail) {
            if (s.charAt(head) != s.charAt(tail)) return false;
            head++;
            tail--;
        }
        return true;
    }*/
   public int minCut(String s) {
        if(s.length()==0)return 0;
        int[]c=new int[s.length()+1];
        for(int i=0;i<s.length();i++)c[i]=Integer.MAX_VALUE;
        c[s.length()]=-1;
        for(int i=s.length()-1;i>=0;i--){
            for(int a=i,b=i;a>=0 && b<s.length() && s.charAt(a)==s.charAt(b);a--,b++) c[a]=Math.min(c[a],1+c[b+1]);
            for(int a=i,b=i+1;a>=0 && b<s.length() && s.charAt(a)==s.charAt(b);a--,b++) c[a]=Math.min(c[a],1+c[b+1]);
        }
        return c[0];
    }