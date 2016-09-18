    //1. Two pointers
    public ListNode deleteDuplicates1(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode p = head, s = head.next;
        
        while (p != null && s != null){
            if(p.val == s.val){
                s = s.next;
            }else{
                p.next = s;
                p = s;
                s = p.next;
            }
        }
        
        p.next = null;
        return head;
    }
    
    //2. Recursive
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }