    //1. Recursive
    public int maxDepth1(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
    
    //2. Iterative
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int level = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(root);

        while(queue.size() > 0){
            int size = queue.size();
            level ++;

            for(int i = 0; i < size; i ++){
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }

        return level;
    }