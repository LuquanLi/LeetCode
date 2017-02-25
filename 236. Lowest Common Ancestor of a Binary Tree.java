 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 找到p q 就return p q， 没找到就 回 null
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 左右有一个空 就是另一个，都不空 就是root
        return left == null ? right : right == null ? left : root;
}