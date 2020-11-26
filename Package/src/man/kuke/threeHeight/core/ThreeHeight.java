package man.kuke.threeHeight.core;

import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

/**
 * 递归求树高度
 */
public class ThreeHeight {
    public int maxDepth(TreeNode root) {
        return treeHeight(root);

    }

    private int treeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null || root.left == null) {
            return 1;
        }

        int height = 0;


        return 1 + Math.max(treeHeight(root.left), treeHeight(root.right));
    }

}
