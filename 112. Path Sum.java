    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.val == sum && root.left == null && root.right == null) return true; //reach the bottom

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }