 public TreeNode sortedArrayToBST1(int[] nums) {
        if(nums == null || nums.length == 0) return null;

        //get medium
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);

        //copy left array
        int[] left_array = new int[mid];
        for(int i = 0; i < mid; i ++){
            left_array[i] = nums[i];
        }
        TreeNode left = sortedArrayToBST(left_array);

        //copy right array
        int[] right_array = new int[nums.length - left_array.length - 1];
        for(int i = mid + 1; i < nums.length; i ++){
            right_array[i - mid - 1] = nums[i];
        }
        TreeNode right = sortedArrayToBST(right_array);

        root.left = left;
        root.right = right;

        return root;
    }
    
    public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) {
            return null;
        }
        TreeNode head = helper(num, 0, num.length - 1);
        return head;
    }

    public TreeNode helper(int[] num, int low, int high) {
        if (low > high) { // Done
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, low, mid - 1);
        node.right = helper(num, mid + 1, high);
        return node;
    }