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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;
        // Find the subRoot root in main tree
        TreeNode foundRoot = dfs(root, subRoot.val);
        return dfs(foundRoot, subRoot);
    }
    private TreeNode dfs(TreeNode root, int searchKey) {
        if(root == null) return null;
        if(root.val == searchKey) return root;
        TreeNode l = dfs(root.left, searchKey);
        TreeNode r = dfs(root.right, searchKey);
        if(l != null) return l;
        if(r != null) return r;
        return null;
    }
    private boolean dfs(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        return dfs(p.left, q.left) && dfs(p.right, q.right);
    }
}
