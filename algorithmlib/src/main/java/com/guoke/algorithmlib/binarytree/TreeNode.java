package com.guoke.algorithmlib.binarytree;

public class TreeNode{

    public TreeNode(int data) {
        this.data = data;
    }

    int data;
    TreeNode left;
    TreeNode right;

    // 构建一个二叉树如下：
    //       1
    //   2       3
    // 4   5   6   7
    //    8   9     10
    public static TreeNode createTree(){
        // 第1层节点
        TreeNode root = new TreeNode(1);

        // 第2层节点
        putLeftAndRight(root,new TreeNode(2),new TreeNode(3));

        // 第3层节点
        putLeftAndRight(root.left,new TreeNode(4),new TreeNode(5));
        putLeftAndRight(root.right,new TreeNode(6),new TreeNode(7));

        // 第4层节点
        // 5 的左节点
        putLeftAndRight(root.left.right,new TreeNode(8),null);

        // 6 的右节点
        putLeftAndRight(root.right.left,null,new TreeNode(9));

        // 7 的右节点
        putLeftAndRight(root.right.right,null,new TreeNode(10));

        return root;
    }

    private static void putLeftAndRight(TreeNode root, TreeNode nodeLeft, TreeNode nodeRight){
        root.left = nodeLeft;
        root.right = nodeRight;
    }

}
