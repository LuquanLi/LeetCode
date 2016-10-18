    public int sumNumbers1(TreeNode root) {
        if(root == null) return 0;

        List<TreeNode> nodeList = new ArrayList<>();
        List<Integer> valueList = new ArrayList<>();

        nodeList.add(root);
        valueList.add(root.val);
        int result = 0;

        while(nodeList.size() > 0){
            List<TreeNode> tmpNodeList = new ArrayList<>();
            List<Integer> tmpValueList = new ArrayList<>();

            for(int i = 0; i < nodeList.size(); i ++){
                TreeNode node = nodeList.get(i);

                if(node.left == null && node.right == null){
                    result += valueList.get(i);
                }
                if(node.left != null){
                    tmpNodeList.add(node.left);
                    tmpValueList.add(valueList.get(i) * 10 + node.left.val);
                }
                if(node.right != null){
                    tmpNodeList.add(node.right);
                    tmpValueList.add(valueList.get(i) * 10 + node.right.val);
                }

            }

            nodeList = tmpNodeList;
            valueList = tmpValueList;
        }

        for(Integer i: valueList){
            result += i;
        }

        return result;
    }
    
    public int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root, 0);
    }

    public int sumNumbersHelper(TreeNode root, int sum){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return sum * 10 + root.val;
        return sumNumbersHelper(root.left, sum * 10 + root.val) + sumNumbersHelper(root.right, sum * 10 + root.val);
    }