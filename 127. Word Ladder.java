 public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord == null || endWord == null || wordList == null) return 0;

        Stack<String> stack = new Stack<>();
        stack.add(beginWord);
        int count = 1;

        while (!stack.isEmpty()){
            Stack<String> newStack = new Stack<>();
            newStack.addAll(stack);
            stack = new Stack<>();

            while(!newStack.isEmpty()){
                char[] strArr = newStack.pop().toCharArray();
                for(int i = 0; i < strArr.length; i ++){
                    char sch = strArr[i];
                    for(char ch = 'a'; ch <= 'z'; ch ++){
                        if(sch != ch){
                            strArr[i] = ch;
                            String tempStr = new String(strArr);
                            if(tempStr.equals(endWord)) return count + 1;
                            if(wordList.contains(tempStr)){
                                stack.push(tempStr);
                                wordList.remove(tempStr);
                            }
                        }
                    }
                    strArr[i] = sch;
                }
            }
            count ++;
        }
        return 0;
    }