    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;

        String[] arr = s.trim().split(" ");
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < arr.length; i ++){
            if(!arr[arr.length - i - 1].equals("")){
                sb.append(arr[arr.length - i - 1]);
                if(i < arr.length - 1) sb.append(" ");
            } 
        }

        return sb.toString();
    }