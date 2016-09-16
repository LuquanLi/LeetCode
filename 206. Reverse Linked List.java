  //1. Recursive
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode second = head.next;
        head.next = null;
        ListNode newHead = reverseList(second);
        second.next = head;

        return newHead;
    }
    
    //2. Iterative
     public ListNode reverseList2(ListNode head) {
        ListNode newHead = null;
        while(head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }