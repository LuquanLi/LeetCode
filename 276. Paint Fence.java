    public int numWays1(int n, int k) {
        if (n == 0 || k == 0) return 0;
        if (n == 1) return k;
        // same[i] means the ith post has the same color with the (i-1)th post.
        int[] same = new int[n];
        // diff[i] means the ith post has a different color with the (i-1)th post.
        int[] diff = new int[n];
        same[0] = same[1] = k;
        diff[0] = k;
        diff[1] = k * (k - 1);
        for (int i = 2; i < n; ++i) {
            same[i] = diff[i-1];//color i-2 and i-1 are different, i is same as i-1
            diff[i] = (k - 1) * same[i-1] + (k - 1) * diff[i-1];
        }
        return same[n-1] + diff[n-1];
    }
    
    public int numWays(int n, int k) {
        if(n == 0) return 0;
        else if(n == 1) return k;
        int diffColorCounts = k*(k-1);
        int sameColorCounts = k;
        for(int i=2; i<n; i++) {
            int temp = diffColorCounts;
            diffColorCounts = (diffColorCounts + sameColorCounts) * (k-1);
            sameColorCounts = temp;
        }
        return diffColorCounts + sameColorCounts;
    }