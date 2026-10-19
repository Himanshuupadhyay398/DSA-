class Solution {
    public boolean isValidBST(TreeNode root) {
        return recurse(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean recurse(TreeNode root, long min, long max) {
        if (root == null) return true;

        if (root.val <= min || root.val >= max) {
            return false;
        }

        return recurse(root.left, min, root.val)
            && recurse(root.right, root.val, max);
    }
}