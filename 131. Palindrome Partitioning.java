    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        partition(s, new ArrayList<String>(), result);
        return result;
    }

    public void partition(String str, List<String> list, List<List<String>> result){
        if(str.equals("")){
            if(list.size() > 0){
                result.add(list);
            }
            return;
        }

        for(int i = 0; i < str.length(); i ++){
            if(isPalindrome(str.substring(0, i + 1))){
                List<String> temp = new ArrayList<>(list);
                temp.add(str.substring(0, i + 1));
                partition(str.substring(i + 1), temp, result);
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
    }