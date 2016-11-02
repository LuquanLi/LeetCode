    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode slow = head, fast = head, pre = null;
        while (fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        pre.next = null;

        head = sortList(head);
        slow = sortList(slow);

        return merge(head, slow);
    }

    private ListNode merge(ListNode l1, ListNode l2){
        ListNode fakeHead = new ListNode(0), pointer = fakeHead;

        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                pointer.next = l1;
                l1 = l1.next;
            }else {
                pointer.next = l2;
                l2 = l2.next;
            }
            pointer = pointer.next;
        }

        if (l1 != null) pointer.next = l1;
        if (l2 != null) pointer.next = l2;

        return fakeHead.next;
    }