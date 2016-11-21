    /* 1. use array to save all values of linkedlist, +1 array, re assign value of linkedlist
       2. reverse linkedlist, +1, reverseback
       3. dummy head and last no nine
     */
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode lastNotNine = dummy, node = head;

        while (node != null){
            if(node.val != 9) lastNotNine = node;
            node = node.next;
        }

        lastNotNine.val ++;
        node = lastNotNine.next;

        while (node != null){
            node.val = 0;
            node = node.next;
        }

        return dummy.val == 1 ? dummy : dummy.next;
    }