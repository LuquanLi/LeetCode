    //1. Recursive
    public boolean isSymmetric1(TreeNode root) {
        return root == null || isSymmetricHelper1(root.left, root.right);
    }

    private boolean isSymmetricHelper1(TreeNode h1, TreeNode h2){
        if(h1 == null || h2 == null) return h1 == h2;
        if(h1.val != h2.val) return false;
        return isSymmetricHelper1(h1.left, h2.right) && isSymmetricHelper1(h1.right, h2.left);
    }
    
    //2. Iterative
    public boolean isSymmetric(TreeNode root) {
        if(root==null)  return true;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode left, right;
        
        switch(isSymmetricHelper(root.left, root.right, stack)){
            case 0: return false;
            case 1: return true;
        }    
            
        while(!stack.empty()){
            if(stack.size() % 2 != 0) return false;
            right = stack.pop();
            left = stack.pop();
            if(right.val!=left.val) return false;
            
            if(isSymmetricHelper(left.left, right.right, stack) == 0) return false;
            if(isSymmetricHelper(left.right, right.left, stack) == 0) return false;
        }
        
        return true;
    }
    
    //1: true, 0: false, 2:do nothing
    private int isSymmetricHelper(TreeNode h1, TreeNode h2, Stack<TreeNode> stack){
        if(h1 == null && h2 == null){
            return 1;
        } else{
            if(h1 == null || h2 == null) return 0;
            stack.push(h1);
            stack.push(h2);
            return 2;
        }
    }