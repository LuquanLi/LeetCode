    //1. Iterative
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode head = new ListNode(0), l1Head = l1, l2Head = l2;

        while (l1Head != null && l2Head != null){
            if(l1Head.val <= l2Head.val){
                head.next = l1Head;
                l1Head = l1Head.next;
            }else {
                head.next = l2Head;
                l2Head = l2Head.next;
            }
            head = head.next;
        }

        if(l1Head == null){
            head.next = l2Head;
        }

        if(l2Head == null){
            head.next = l1Head;
        }

        return l1.val <= l2.val ? l1 : l2;
    }
    
    //2. Recursive
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val < l2.val){
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }