package lc.codingcarl.tree;

/**
 * @Desc 654. 最大二叉树
 * @Author h2linlin
 */
public class N0654 {

    /**
     * 解法1：递归。
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        TreeNode midNode = new TreeNode();

        // 1.叶子节点
        if (nums.length == 1) {
            midNode.val = nums[0];
            return midNode;
        }

        // 2.寻找最大值，及其下标
        int maxValue = Integer.MIN_VALUE;
        int maxFlag = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxFlag = i;
            }
        }
        midNode.val = maxValue;

        // 3.构建左子树
        int[] leftNums = new int[maxFlag];
        for (int i = 0; i < maxFlag; i++) {
            leftNums[i] = nums[i];
        }

        // 4.构建右子树
        int[] rightNums = new int[nums.length - maxFlag - 1];
        for (int i = maxFlag + 1; i < nums.length; i++) {
            rightNums[i - maxFlag - 1] = nums[i];
        }

        // 5.返回结果
        midNode.left = constructMaximumBinaryTree(leftNums);
        midNode.right = constructMaximumBinaryTree(rightNums);

        return midNode;
    }

    /**
     * 解法2：递归。解法1的优化，改为使用下标，而不是新建数组。
     */
    public TreeNode constructMaximumBinaryTree2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return buildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        // 1.叶子节点
        if (start == end) {
            TreeNode treeNode = new TreeNode();
            treeNode.val = nums[start];
            return treeNode;
        }

        // 2.寻找最大值
        int max = Integer.MIN_VALUE;
        int maxFlag = -1;
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxFlag = i;
            }
        }

        // 3.构建节点返回
        TreeNode midNode = new TreeNode();
        midNode.val = max;
        midNode.left = buildTree(nums, start, maxFlag - 1);
        midNode.right = buildTree(nums, maxFlag + 1, end);
        return midNode;
    }
}
