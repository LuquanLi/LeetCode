    //https://en.wikipedia.org/wiki/IP_address#IPv4_addresses
    //8bits:8bits:8bits:8bits  -> largest number can be represent is: each ranging from 0 to 255

    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if(s == null || s.length() < 4) return list;
        search(s, 0, "", list);
        return list;
    }


    public void search(String str, int count, String result, List list){
        //the last one
        if(count == 3){
            if(isValid(str)){
                result += str;
                list.add(result);
            }
            return;
        }

        for(int i = 0; i < 3; i ++){
            if(str.length() < i + 1) break;
            String sub = str.substring(0, i + 1);
            if(isValid(sub)){
                search(str.substring(i + 1), count + 1, result + sub + ".", list);
            }
        }
    }

    public boolean isValid(String str){
        if(str.length() == 0 ||str.length() > 3 || (str.length() > 1 && str.charAt(0) == '0')) return false;
        int value = Integer.valueOf(str);
        return (value >= 0 && value <= 255);
    }