    //Original one
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode fakehead = new ListNode(0), p = fakehead;
        int carry = 0;

        while (l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            ListNode node;
            if(sum >= 10){
                node = new ListNode(sum % 10);
                carry = 1;
            }else {
                node = new ListNode(sum);
                carry = 0;
            }
            p.next = node;
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if(l1 == null){
            while (l2 != null){
                int sum = l2.val + carry;
                ListNode node;
                if(sum >= 10){
                    node = new ListNode(sum % 10);
                    carry = 1;
                }else {
                    node = new ListNode(sum);
                    carry = 0;
                }
                p.next = node;
                p = p.next;
                l2 = l2.next;
            }
        }

        if(l2 == null){
            while (l1 != null){
                int sum = l1.val + carry;
                ListNode node;
                if(sum >= 10){
                    node = new ListNode(sum % 10);
                    carry = 1;
                }else {
                    node = new ListNode(sum);
                    carry = 0;
                }
                p.next = node;
                p = p.next;
                l1 = l1.next;
            }
        }

        if(carry == 1){
            ListNode node = new ListNode(1);
            p.next = node;
        }

        return fakehead.next;
    }
    
    //Concise one
     public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        ListNode fakehead = new ListNode(0), p = fakehead;
        int carry = 0;

        while (l1 != null || l2 != null){
            int sum = carry + ((l1 == null) ? 0 : l1.val) + ((l2 == null) ? 0 : l2.val);

            carry = sum / 10;
            p.next = new ListNode(sum % 10);
            p = p.next;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        if(carry == 1){
            p.next = new ListNode(1);
        }

        return fakehead.next;
    }