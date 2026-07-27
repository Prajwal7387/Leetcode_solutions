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
import java.util.*;

class Solution {

    private int currentVal;
    private int currentCount = 0;
    private int maxCount = 0;

    private List<Integer> ans = new ArrayList<>();

    public int[] findMode(TreeNode root) {

        inorder(root);

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }

    private void inorder(TreeNode node) {

        if (node == null)
            return;

        inorder(node.left);

        if (currentCount == 0 || node.val != currentVal) {
            currentVal = node.val;
            currentCount = 1;
        } else {
            currentCount++;
        }

        if (currentCount > maxCount) {
            maxCount = currentCount;
            ans.clear();
            ans.add(currentVal);
        } else if (currentCount == maxCount) {
            ans.add(currentVal);
        }

        inorder(node.right);
    }
}