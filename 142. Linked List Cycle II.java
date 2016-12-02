//1 -> 2 -> 3 -> 4
    //      <--------
    //cycle begin at 2

    //we can have one pointer, loop through the list, the first node have been touched before it is the starter or no cycle
    //change class ListNode -> boolean visited = false;
    
    
    //two pointers
    public ListNode detectCycle(ListNode head) {
         ListNode slow = head;
         ListNode fast = head;
        
         while (fast!=null && fast.next!=null){
             fast = fast.next.next;
             slow = slow.next;
                    
             if (fast == slow){
                 ListNode slow2 = head; 
                 while (slow2 != slow){
                      slow = slow.next;
                      slow2 = slow2.next;
                 }
                 return slow;
             }
         }
         return null;
    }