/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        return solve(root, p, q);
    }

    public TreeNode solve(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
            
        if (root == p || root == q) {
            return root;
        }
        TreeNode l = solve(root.left, p, q);
        TreeNode r = solve(root.right, p, q);

        if (l != null && r != null)
            return root;
        return l == null ? r : l;
    }
}