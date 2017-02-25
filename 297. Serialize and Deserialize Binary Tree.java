   // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuffer sb = new StringBuffer();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            if (t != null) {
                sb.append(String.valueOf(t.val) + ",");
                queue.add(t.left);
                queue.add(t.right);
            } else {
                sb.append("#,");
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;

        String[] array = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(array[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();

            if (t == null) continue;

            if (!array[i].equals("#")) {
                t.left = new TreeNode(Integer.parseInt(array[i]));
                queue.offer(t.left);
            } else {
                t.left = null;
                queue.offer(null);
            }
            i ++;

            if (!array[i].equals("#")) {
                t.right = new TreeNode(Integer.parseInt(array[i]));
                queue.offer(t.right);
            } else {
                t.right = null;
                queue.offer(null);
            }
            i ++;
        }

        return root;
    }