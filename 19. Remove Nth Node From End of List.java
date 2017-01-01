//1. loop twice
    //2. two pointers, use fakehead incase we need remove the head
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;

        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode p = fakeHead, q = fakeHead;

        //q move n steps
        while (n-- > 0){
            q = q.next;
        }

        //move q and p together
        while (q != null && q.next != null){
            p = p.next;
            q = q.next;
        }

        //remove p.next
        if(p.next != null){
            p.next = p.next.next;
        }

        return fakeHead.next;
    }