/*1. 
mutiply str1, str2

str1 long, str2 short

int mul = 1;
List<String> results;
for(int i = str2.len - 1; i >= 0; i --){
	str2.charat(i) * 1 * each in str1;
	results.add();
	mul *= 10;
}

add all in results together.*/

//2. https://discuss.leetcode.com/topic/30508/easiest-java-solution-with-graph-explanation/2
public String multiply(String num1, String num2) {
    int m = num1.length(), n = num2.length();
    int[] pos = new int[m + n];
   
    for(int i = m - 1; i >= 0; i--) {
        for(int j = n - 1; j >= 0; j--) {
            int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
            int p1 = i + j, p2 = i + j + 1;
            int sum = mul + pos[p2];

            pos[p1] += sum / 10;
            pos[p2] = (sum) % 10;
        }
    }  
    
    StringBuilder sb = new StringBuilder();
    for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
    return sb.length() == 0 ? "0" : sb.toString();
}

/*

         1 2 3     i(0,1,2)
           4 5     j(  0,1)
        ------
           1 5     count for (i + j, i + j + 1)
         1 0
       0 5
         1 2
       0 8
     0 4 
     ---------
     0 5 5 3 5
 re (0 1 2 3 4)
 */





