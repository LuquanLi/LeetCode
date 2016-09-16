 	public boolean isPowerOfFour(int num) {
        //1.11 % 1 = 0.11
        return (Math.log(num) / Math.log(4)) % 1 == 0;
    }