    //Simple Method
    /*
    1. Find all substrings  O(n2)
    2. Decide whether this substring has duplicate char, keep max length in record, O(n) to decide whether one string has duplicate
    3. Return max

    Totally take O(n3) time and O(1) space
    */

    //extra work here, once we know a substr has dupe, we do not need to move forward to check the str wo contains this substr

    //Two pointers: i, j
    //substr = str.sub(i,j+1)
    //set to keep all char in current substr
    //1. move j forward, check char j in set,
    //2. if there is not dupe, set.add(j);
    //3. if there is dupe, move i forward, until char i - 1 == char j, update set and max len

    //Time O(n), Space O(n) for set, O(1) for the max
    public int lengthOfLongestSubstring(String s) {
        //check input validation
        if(s == null || s.length() == 0) return 0;

        //set to keep the current chars in substring
        Set<Character> set = new HashSet<>();

        //keep the current max len
        int max = 0;

        //Two pointers start at beginning
        int i = 0, j = 0;

        //Loop through the string
        while (j < s.length()){
            if(set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i ++;
            }else{
                set.add(s.charAt(j));
                max = Math.max(max, j - i + 1);
                j ++;
            }
        }

        return max;
    }
    
    //Test Case
    //s = null, s = "", s="a", s = "aaaaaaaaa", s = "abababcabc";