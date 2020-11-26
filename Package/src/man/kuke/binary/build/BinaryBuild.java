package man.kuke.binary.build;

import java.util.HashMap;
import java.util.Map;

public class BinaryBuild {
    Map<Integer,Integer> map ;

    /**
     * 中序遍历   4，2，5，1，6，3，7
     * 先序遍历   1，2，4，5，3，6，7
     *
     * 根 1
     * 中序 左子节点（4，2，5）1（6，3，7）右子节点
     * 先序 1（2，4，5）（3，6，7）
     * 递归分解
     * 中序遍历（4，2，5）
     * 先序遍历（1，4，5）
     *
     * 中序遍历（6，3，7）
     * 先序遍历（3，6，7）
     *
     * 递归每次剥离出一个根节点 构建树结构，直至左树 或右数 为空
     * 本质上确定递归每次确定先序遍历和中序遍历的区域界限
     *
     * @param preorder 先序数组
     * @param inorder  中数组
     * @param preLeft  先序左边界
     * @param preRight  先序右边界
     * @param inoLeft  中序左边界
     * @param inoRight  中序右边界
     * @return
     */
    public TreeNode build(int[] preorder, int[] inorder,int preLeft,int preRight, int inoLeft,int inoRight) {
        if (preLeft > preRight) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[preLeft]);
        int indexRoot =  map.get(preorder[preLeft]);
        int leftPartSize = indexRoot - inoLeft;

        treeNode.left =  build(preorder, inorder, preLeft + 1, preLeft + leftPartSize,
                inoLeft,indexRoot - 1);
        treeNode.right = build(preorder, inorder, preLeft + 1 + leftPartSize, preRight,
                indexRoot + 1,inoRight);
        return treeNode;

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }

        return build(preorder,inorder, 0, preorder.length - 1,
                0, inorder.length - 1);
    }
}
