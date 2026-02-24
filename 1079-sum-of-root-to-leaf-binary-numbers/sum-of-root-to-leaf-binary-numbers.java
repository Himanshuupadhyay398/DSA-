/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int sum=0;
    public int sumRootToLeaf(TreeNode root) {
        String str="";
        preorder(root,str);
    return sum;
    }
    public void preorder(TreeNode root,String str){
        if(root==null) return;
        str=str+root.val;
        if(root.left==null && root.right==null){
            sum+=Integer.parseInt(str,2);
            return;
        }
        preorder(root.left,str);
        preorder(root.right,str);
    }
}