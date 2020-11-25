package man.kuke.core;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.

    public String dealRoot(TreeNode root) {
       return root.val + ",";
    }


    public String travelTree(TreeNode root,String data) {
        if (root == null) {
            return data + "null,";
        }
        data += dealRoot(root);
        data = travelTree(root.left,data);
        data = travelTree(root.right,data);

        return data;
    }


    public String serialize(TreeNode root) {
       String data =  travelTree(root,"");

        return data;
    }

    public TreeNode bulider(LinkedList<String> datas) {
        String data = datas.remove(0);

        if (data.equalsIgnoreCase("null")) {
            return null;
        }

        TreeNode treeNode= new TreeNode(Integer.parseInt(data));
        treeNode.left = bulider(datas);
        treeNode.right = bulider(datas);
        return treeNode;
    }

    public TreeNode deserialize(String data) {
        LinkedList<String> datas = new LinkedList<>(Arrays.asList(data.split(",")));
        TreeNode tree = bulider(datas);

        return tree;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));