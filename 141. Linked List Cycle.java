    //use a set to save zou guo de node - time limit exceed
    public boolean hasCycle1(ListNode head) {
        if(head == null || head.next == null) return false;

        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if(set.contains(head)) return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }

    //slow and faster pointer
    //prove it ... suppose there is a cycle, length is n, fast is at point x when slow just arrive, which at point 0
    /* |---x---|
       |       |
       0-------|
    imagine they are not in a loop, they are in a infinite long trace
    the time fast to catch up slow is dist(fast-slow)/diff(speed) -> (n - x)/1 -> fast will catch up slow finally */
    //after (n-x) time, slow run (n-x) dist, fast run 2(n-x)
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }