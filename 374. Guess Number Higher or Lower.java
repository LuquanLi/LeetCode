    public int guessNumber1(int n) {
        for (int i = 1; i < n; i++){
            if (guess(i) == 0) return i;
        }
        return n;
    }

    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            if (res == 0){
                return mid;
            } else if (res < 0){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }