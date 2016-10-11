    //for general case: 12343545623134125243
    public ListNode oddEvenList1(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode odd = new ListNode(1), even = new ListNode(0), 
                oddHead = new ListNode(-1), evenHead = new ListNode(-2);

        while (head != null){
            if(head.val % 2 == 0){
                even.next = head;
                if (evenHead.next == null)  evenHead.next = head;
                even =even.next;
            }else{
                odd.next = head;
                if (oddHead.next == null)  oddHead.next = head;
                odd = odd.next;
            }
            head = head.next;
        }
        
        //connect them
        odd.next = evenHead.next;
        
        return oddHead.next != null ? oddHead.next : evenHead.next; 
    }
    
    //for 123456.. inorder
    public ListNode oddEvenList(ListNode head) {
        if (head != null) {
        
            ListNode odd = head, even = head.next, evenHead = head.next; 
        
            while (even != null && even.next != null) {
                odd.next = odd.next.next; 
                even.next = even.next.next; 
                odd = odd.next;
                even = even.next;
            }
            odd.next = evenHead; 
        }
        return head;
    }