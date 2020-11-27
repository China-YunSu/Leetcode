package man.kuke.binary.maxPath;

/**
 * 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
 * 该路径至少包含一个节点，<code>且不一定经过根节点。</code>
 *             1
 *            / \
 *           2   3
 *      路径有 :
 *              2
 *              3
 *              1->2->3
 *      最大路径路径 1->2->3  maxprice = 6
 *

 *      该题要求必须是父节点->子节点方向  <code>出发节点的子节点，可以横向穿越</code>。
 *      最大路径求解
 *      定义：子节点值大于0，则子节点有贡献值为本值，否则为0.
 *      本树的最大贡献值等于本节点的值加上其左右子树中最大的树值。
 *      从任意节点出发点最大路径 等于 该节点的值 + 子树的最大贡献值。
 *
 *      该题本质是求任意节点出发得最大路径值的最大值。
 *          -10
 *          / \
 *         9  20
 *         /  \
 *        15   7
 *    路径有：
 *     出发节点-10     -10->9->20->15   price = 34
 *     出发节点-10     -10->9->20->7    price = 26
 *     出发节点9        9               price = 9
 *     出发节点20       20->15->7       price = 42
 *     出发节点15       15              price = 15
 *     出发节点8        7               price = 7
 *                                     maxprice = 42
 */
public class BinaryMaxPath {
    public int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }

        int leftMax = Math.max(maxPathSum(root.left),0);
        int rightMax = Math.max(maxPathSum(root.right),0);

        int pricePath = leftMax + rightMax + root.val;
        maxSum = Math.max(pricePath, maxSum);

        return root.val + Math.max(leftMax, rightMax);

    }
}
