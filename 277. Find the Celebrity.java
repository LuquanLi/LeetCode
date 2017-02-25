 /* public int findCelebrity(int n) {
        if (n <= 0) return -1;
        
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (j == i) continue;
                if (!knows(j, i) || knows(i,j)) break;
                if (j == n - 1 || (i == n - 1 && j == n - 2)) return i;
            }
        }
        
        return -1;
    }*/
    public int findCelebrity(int n) {
        int candidate = 0;
        for(int i = 1; i < n; i++){
            if(knows(candidate, i))
                candidate = i;
        }
        for(int i = 0; i < n; i++){
            if(i != candidate && (knows(candidate, i) || !knows(i, candidate))) return -1;
        }
        return candidate;
    }