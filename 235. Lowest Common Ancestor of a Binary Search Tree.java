    //1.
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(p == null || q == null) return root;

        if(p.val < root.val && q.val > root.val) return root;
        if(p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        if(p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);

        return root;
    }
    //2.
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0){ // ->  p and q on same side
            root = p.val < root.val ? root.left : root.right;
        }
        return root;
    }
    //3.
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return (root.val - p.val) * (root.val - q.val) < 1 ? root :
           lowestCommonAncestor(p.val < root.val ? root.left : root.right, p, q);
    }