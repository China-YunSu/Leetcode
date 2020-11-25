package man.kuke.core;



import java.util.LinkedList;

public class Codec2 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        StringBuffer buffer = new StringBuffer();
        queue.addFirst(root);

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.removeFirst();
            dealNode(treeNode,buffer);
            if (treeNode == null) {
                continue;
            }
            queue.addLast(treeNode.left);
            queue.addLast(treeNode.right);
        }
        return buffer.toString();

    }

    private void dealNode(TreeNode treeNode, StringBuffer buffer) {
        buffer.append(treeNode == null ? null:treeNode.val).append(",");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        LinkedList<TreeNode> queue = new LinkedList<>();

        int index = 0;
        TreeNode treeNode = null;
        if (!split[index].equalsIgnoreCase("null")) {
            treeNode = new TreeNode(Integer.parseInt(split[index++]));
            queue.addLast(treeNode);
        }
        while(!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            if (!split[index].equalsIgnoreCase("null")) {
                node.left = new TreeNode(Integer.parseInt(split[index]));
                queue.addLast(node.left);
            }
            index++;
            if (!split[index].equalsIgnoreCase("null")) {
                node.right = new TreeNode(Integer.parseInt(split[index]));
                queue.addLast(node.right);
            }
            index++;
        }

        return treeNode;
    }
}
