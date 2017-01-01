    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;

        int leftNodesNum = getNumofNodes(root.left);

        if(leftNodesNum == k - 1){
            return root.val;
        }else if (leftNodesNum < k - 1){
            return kthSmallest(root.left, k - leftNodesNum - 1);
        }else {
            return kthSmallest(root.left, k);
        }

    }

    private int getNumofNodes(TreeNode root){
        if(root == null) return 0;
        return getNumofNodes(root.left) + getNumofNodes(root.right) + 1;
    }