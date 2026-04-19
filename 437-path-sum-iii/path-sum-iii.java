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
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);

        return DFS(root, 0L, targetSum, prefix);
    }
    private int DFS(TreeNode node, long currSum, int targetSum, Map<Long, Integer> prefix){
        if(node == null) return 0;

        currSum += node.val;
        int cnt = prefix.getOrDefault(currSum - targetSum, 0);

        prefix.put(currSum, prefix.getOrDefault(currSum, 0)+1);

        cnt += DFS(node.left, currSum, targetSum, prefix);
        cnt += DFS(node.right, currSum, targetSum, prefix);

        prefix.put(currSum, prefix.get(currSum) - 1);

        return cnt;
    }
}