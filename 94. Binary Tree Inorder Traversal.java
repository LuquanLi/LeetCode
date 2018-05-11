// recursive
List<Integer> result = new ArrayList<>();
public List<Integer> inorderTraversal(TreeNode root) {
    if (root == null) return result;

    if (root.left != null) inorderTraversal(root.left);
    result.add(root.val);
    if (root.right != null) inorderTraversal(root.right);

    return result;
}

// stack
public List < Integer > inorderTraversal(TreeNode root) {
    List < Integer > res = new ArrayList < > ();
    Stack < TreeNode > stack = new Stack < > ();
    TreeNode curr = root;
    while (curr != null || !stack.isEmpty()) {
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.pop();
        res.add(curr.val);
        curr = curr.right;
    }
    return res;
}