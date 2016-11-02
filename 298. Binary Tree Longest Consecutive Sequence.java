    public int longestConsecutive(TreeNode root) {
        return dfs(root, null, 0);
    }

    private int dfs (TreeNode node, TreeNode parent, int len){
        if(node == null) return len;
        len = (parent != null && parent.val + 1 == node.val) ? len + 1 : 1;
        return Math.max(len, Math.max(dfs(node.left, node, len), dfs(node.right, node, len)));
    }