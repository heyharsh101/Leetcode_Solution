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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null) return null;
        return build(nums, 0, nums.length-1);
    }
    public TreeNode build(int[] nums, int l, int r){
        if(l>r) return null;

        int idxmax = l;
        for(int i= l+1; i<=r; i++){
            if(nums[i] > nums[idxmax]){
                idxmax = i;
            }
        }
        TreeNode root = new TreeNode(nums[idxmax]);

        root.left = build(nums, l, idxmax-1);
        root.right = build(nums, idxmax+1, r);

        return root;
    }
}