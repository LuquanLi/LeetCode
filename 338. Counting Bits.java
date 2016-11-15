    //1. Loop from 0 - m, calculate each i
    //2. f(i) = f(i/2) + i%2
    /*  0    0    f(0) = 0
        1    01   f(1) = 1
        2    10   f(2) = f(1) * 2
        3    11   f(3) = f(1) * 2 + 1
        4    100  f(4) = f(2) * 2
        5    101  f(5) = f(2) * 2 + 1
        6    110  f(6) = f(3) * 2 ...
     */
    public int[] countBits(int num) {
        int[] f = new int[num + 1];
        for(int i = 1; i <= num; i ++){
            f[i] = f[i/2] + i % 2;
        }
        return f;
    }