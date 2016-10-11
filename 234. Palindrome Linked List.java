    //1. stack
    public boolean isPalindrome(ListNode head) {
        //1. know the length
        int length = 0;
        ListNode newHead = head;
        while (newHead != null){
            newHead = newHead.next;
            length ++;
        }

        //2. stack
        Stack<Integer> stack = new Stack<>();
        int counter = 0;
        while (counter < length / 2){
            stack.add(head.val);
            head = head.next;
            counter ++;
        }

        if(length % 2 != 0) head = head.next; //odd

        while (head != null){
            if(stack.pop() != head.val) return false;
            head = head.next;
        }

        return true;
    }
    //2. Reverse linkedlist