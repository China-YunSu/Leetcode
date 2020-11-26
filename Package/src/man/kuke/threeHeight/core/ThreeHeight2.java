package man.kuke.threeHeight.core;

import java.util.LinkedList;

public class ThreeHeight2 {
    /**
     * 二叉树队列层次递归
     * @param root 树节点
     * @return 树高度
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        int height = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode treeNode = queue.removeFirst();
                dealThreeNode(queue,treeNode);
            }
            ++height;
        }

        return height;
    }


    private void dealThreeNode(LinkedList<TreeNode> queue, TreeNode node) {
      if (node.left != null) {
          queue.addLast(node.left);
      }
      if (node.right != null) {
          queue.addLast(node.right);
      }
    }


}
