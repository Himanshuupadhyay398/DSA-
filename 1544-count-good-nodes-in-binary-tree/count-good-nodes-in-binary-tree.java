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
    int maxCount=0;
    public int goodNodes(TreeNode root) {
        return help(root,root.val);
    }
    public int help(TreeNode root,int maxElement){
        if(root==null) return 0;

        if(root.val>=maxElement){
           maxElement=root.val;

            maxCount++;
        }
        
        help(root.left,maxElement);
        help(root.right,maxElement);
    return maxCount;
    }
}