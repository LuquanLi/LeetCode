public class LRUCache {
    private class Node{
        Node prev;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
        private int capacity;
        private HashMap<Integer, Node> map = new HashMap<>();
        private Node head = new Node(0, 0);
        private Node tail = new Node(0, 0);

        public LRUCache(int capacity) {
            this.capacity = capacity;
            tail.prev = head;
            head.next = tail;
        }

        public int get(int key) {
            if(!map.containsKey(key)) return -1;

            //remove node
            Node node = map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;

            //move node to tail
            movetoTail(node);

            return map.get(key).value;
        }

        public void set(int key, int value) {
            if(get(key) != -1){
                Node node = map.get(key);
                node.value = value; //update node value
                //movetoTail(node); //why not move to tail?!
                return;
            }

            //Add a node
            //Check capacity
            if(map.size() == capacity){
                map.remove(head.next.key);
                head.next = head.next.next;
                head.next.prev = head;
            }

            //insert
            Node insert = new Node(key, value);
            map.put(key, insert);
            movetoTail(insert);
        }

        private void movetoTail(Node node){
            node.prev = tail.prev;
            tail.prev = node;
            node.prev.next = node;
            node.next = tail;
        }
}
