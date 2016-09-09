//292. Nim Game
public class Solution {
    //1. Recursive: time out
    public boolean canWinNim1(int n){
        if(n <= 3) return true;
        return !canWinNim1(n - 1) || !canWinNim1(n - 2) ||!canWinNim1(n - 3);
    }

    //2. Iterative: Memory Limit Exceeded
    public boolean canWinNim2(int n) {
        if(n <= 3) return true;

        boolean[] result = new boolean[n + 1];
        result[1] = true;
        result[2] = true;
        result[3] = true;

        for(int i = 4; i < n + 1; i ++){
            result[i] = !result[i - 1] || !result[i - 2] || !result[i - 3];
        }

        return result[n];
    }

    //3. Only keep recent 3 results: time out
    public boolean canWinNim3(int n){
        if(n <= 3) return true;

        boolean[] result = {true, true, true};

        for(int i = 4; i < n; i ++){
            int index = i % 3 - 1;
            if(index == -1) index = 2;
            result[index] = !result[0] || !result[1] || !result[2];
        }

        return !result[0] || !result[1] || !result[2];
    }

    //4. Math
    public boolean canWinNim(int n){
        return n % 4 != 0;
    }
}