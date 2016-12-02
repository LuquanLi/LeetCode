//insert sort: compare the new element with all existing elements, O(n2)
    //1. create a new fake head
    //2. take node one by one from head, insert into the list of fakehead
    //3. return fakehead.next
    public ListNode insertionSortList(ListNode head) {
        //Check input validation
        if(head == null || head.next == null) return head;
        
        //Create a new fake head
        ListNode fakeHead = new ListNode(-1);
        
        //Insert each nodes
        while(head != null){
            
            //temp as a pointer for new list
            ListNode temp = fakeHead;
            
            //take a copy of current head
            ListNode insert = new ListNode(head.val);

            while (temp.next != null && insert.val >= temp.next.val){
                temp = temp.next;
            }

            insert.next = temp.next;
            temp.next = insert;
            
            head = head.next;
        }
        
        return fakeHead.next;
    }
    
    //Test case
    /* 1. head = null  -> return null
       2. only 1 node :  (1)   -> return (1)
       3. 3 nodes:  (2)(1)(3)  -> 
       4. same value nodes: (1)(1)
     */