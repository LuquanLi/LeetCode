    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode newHead = new ListNode(Integer.MAX_VALUE);
        ListNode fast = head, slow = newHead;
        newHead.next = fast;

        while (fast != null){
            //find the last node of the dupe
            while(fast.next != null && fast.val == fast.next.val){
                fast = fast.next;
            }
            if(slow.next != fast){
                fast = fast.next;
                slow.next = fast;
            }else {
                slow = slow.next;
                fast = fast.next;
            }
        }

        return newHead.next;
    }