package man.kuke.threeHeight.core;

import java.util.LinkedList;

public class ThreeHeight2 {
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
