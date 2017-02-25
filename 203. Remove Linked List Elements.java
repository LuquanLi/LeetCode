    public ListNode removeElements(ListNode head, int val) {
        ListNode newHaed = new ListNode(-1);
        newHaed.next = head;

        ListNode p = newHaed, q = head;
        while (q != null) {
            if (q.val != val) {
                p = p.next;
                q = q.next;
            } else {
                p.next = q.next;
                q = p.next;
            }
        }
        
        return newHaed.next;
    }