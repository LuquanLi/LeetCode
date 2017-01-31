    //1. Iterative
    public ListNode swapPairs1(ListNode head) {
       if(head == null || head.next == null) return head;
        ListNode p = head, q = head.next, newHead = head.next;

        while (p != null && q != null){
            p.next = q.next;
            q.next = p;
            p = p.next;
            if( p != null) q = p.next;
        }

        return newHead;
    }
    
    //2. Recursion
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }