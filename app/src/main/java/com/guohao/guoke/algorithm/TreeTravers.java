package com.guohao.guoke.algorithm;

import java.util.LinkedList;

/**
 * 树的前中后遍历，层次遍历，带层次统计
 */
public class TreeTravers {

    public static void main(String args[]){

        TreeNode root = TreeNode.createTree();
        System.out.print("前序：");
        preOrderTraverse(root);

        System.out.print("\n中序：");
        inOrderTraverse(root);

        System.out.print("\n后序：");
        postOrderTraverse(root);

        System.out.print("\n层次遍历：");
        levelTraverse(root);// 层次遍历

        System.out.println(" ");
        levelTraverseWithLevel(root);// 层次遍历，带层次输出

        System.out.println(" ");
        //traverseWithLevel(root);// 前中后序的遍历，带层次统计，也是可用的
    }

    // 先序遍历
    public static void preOrderTraverse(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }
    // 中序遍历
    public static void inOrderTraverse(TreeNode node) {
        if (node == null)
            return;
        inOrderTraverse(node.left);
        System.out.print(node.data + " ");
        inOrderTraverse(node.right);
    }
    // 后序遍历
    public static void postOrderTraverse(TreeNode node) {
        if (node == null)
            return;
        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        System.out.print(node.data + " ");
    }

    // 层次遍历
    public static void levelTraverse(TreeNode root){

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.data + " ");
            if(node.left!=null)queue.add(node.left);
            if(node.right!=null)queue.add(node.right);
        }
    }

    // 改进版的层次遍历
    public static void levelTraverseWithLevel(TreeNode root){
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 1;

        while(!queue.isEmpty()){

            int size = queue.size(); //当前层有几个节点，就遍历几次

            for(int i = 0; i < size; i++){ // 每次循环是一层
                if( i == 0){
                    System.out.print(String.format("第%d层：",depth));
                }
                TreeNode node = queue.poll();
                System.out.print(node.data + " ");
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            System.out.println(" ");
            depth++;
        }
    }

    // 遍历，并打印出层次
    public static void traverseWithLevel(TreeNode root){
        int depth = 1;
        LinkedList<TreeNode> nodeQueue = new LinkedList<>();
        LinkedList<Integer> depthQueue = new LinkedList<>();
        recursionEnqueue(root,depth ,nodeQueue,depthQueue);

        while(!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.poll();
            System.out.print(node.data + " ");
        }
        System.out.println(" ");
        while(!depthQueue.isEmpty()){
            Integer node = depthQueue.poll();
            System.out.print(node + " ");
        }

    }

    // 前序遍历
    private static void recursionEnqueue(TreeNode node, int depth, LinkedList<TreeNode> nodeQueue, LinkedList<Integer> depthQueue){
        if(node == null) return;
        nodeQueue.add(node);
        depthQueue.add(depth);
        recursionEnqueue(node.left,depth + 1,nodeQueue,depthQueue);
        recursionEnqueue(node.right,depth + 1,nodeQueue,depthQueue);
    }

}
