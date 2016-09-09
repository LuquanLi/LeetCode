//344. Reverse String
public class Solution {

    //1. use string buffer or string builder
    public String reverseString(String s) {
        StringBuffer sb = new StringBuffer(s).reverse();
        return sb.toString();
    }

    //2. use char array
    public String reverseString2(String s) {
        int len = s.length();
        char[] arr = new char[len];

        for(int i=0; i<len ; i++){
            arr[i]= s.charAt(len-i-1);
        }

        return new String(arr);
    }
}