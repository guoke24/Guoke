package com.guoke.algorithmlib.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给类都有如下方法：
 * 二叉树的前中后遍历（递归和非递归的），
 * 简单版的层次遍历（while循环），
 * 带层次统计的层次遍历（while+for循环），
 * 带层次统计的前序遍历。
 */
public class TreeTravers {


    public static void main(String args[]){

        // 构建一个二叉树如下：
        //       1
        //   2       3
        // 4   5   6   7
        //    8   9     10
        TreeNode root = TreeNode.createTree();

        System.out.print("递归的");

        System.out.print("\n前序遍历：");
        preOrderTraverse(root);

        System.out.print("\n中序遍历：");
        inOrderTraverse(root);

        System.out.print("\n后序遍历：");
        postOrderTraverse(root);

        System.out.print("\n\n非递归的");

        System.out.print("\n前序遍历：");
        preOrderTraverse_NoRecursion(root);

        System.out.print("\n中序遍历：");
        midOrderTraverse_NoRecursion(root);

        System.out.print("\n第一种后序遍历：");
        postOrderTraverse_NoRecursion(root);

        System.out.print("\n第二种后序遍历：");
        postOrderTraverse_NoRecursion2(root);

        // =============================

        System.out.print("\n\n层次遍历：");
        levelTraverse(root);// 层次遍历

        System.out.print("\n\n层次遍历，带层次输出：");
        levelTraverseWithLevel(root);// 层次遍历，带层次输出

        System.out.print("\n\n带层次统计的前序遍历：");
        traverseWithLevel(root);

        System.out.print("\n");
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


    /**
     * 层次遍历，利用了队列的特性。
     *
     * @param root
     */
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

    /**
     * 改进版的层次遍历。
     * 改进点在于 while 循环中 加了一个 for 循环；
     * for 循环用于遍历当前层的元素，同时还可以感知层次。
     *
     * @param root
     */
    public static void levelTraverseWithLevel(TreeNode root){
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 1;
        System.out.println(" ");
        while(!queue.isEmpty()){

            int size = queue.size(); //当前层有几个节点，就遍历几次

            for(int i = 0; i < size; i++){ // 每次循环是一层
                if( i == 0){
                    System.out.print(String.format("第%d层：",depth));
                }
                TreeNode node = queue.poll();
                System.out.print(node.data + " ");

                // 精髓点在此：由于遍历的都是当前层，所以此处入队的都是下一层
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            if(!queue.isEmpty()) System.out.println(" ");
            depth++;
        }
    }

    // 先序遍历并入队，随后遍历队列打印出节点和对应的层次
    public static void traverseWithLevel(TreeNode root){
        int depth = 1;
        LinkedList<TreeNode> nodeQueue = new LinkedList<>();
        LinkedList<Integer> depthQueue = new LinkedList<>();
        recursionEnqueue(root,depth ,nodeQueue,depthQueue);

        System.out.println(" ");
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

    /**
     * 先序遍历的同时，把节点和对应的层次入队
     * 遍历到某个节点时，节点和对应的深度同时入队，这样就有对应关系，便于打印
     *
     * @param node  头节点
     * @param depth 深度
     * @param nodeQueue  节点队列
     * @param depthQueue 深度队列，就是记录某个节点的深度的 Int 值的队列
     */
    private static void recursionEnqueue(TreeNode node, int depth, LinkedList<TreeNode> nodeQueue, LinkedList<Integer> depthQueue){
        if(node == null) return;
        nodeQueue.add(node);   // 记录节点
        depthQueue.add(depth); // 记录节点对应的深度
        recursionEnqueue(node.left,depth + 1,nodeQueue,depthQueue);
        recursionEnqueue(node.right,depth + 1,nodeQueue,depthQueue);
    }

    // ===== 非递归的前中后遍历 =====

    /**
     * 非递归的前序遍历，利用了 Stack 的特性
     *
     * @param root
     */
    private static void preOrderTraverse_NoRecursion(TreeNode root){
        Stack s1 = new Stack<TreeNode>();
        List<TreeNode> res = new ArrayList<TreeNode>();
        TreeNode cur = root;
        while(cur != null || !s1.isEmpty()){
            if(cur != null){
                s1.push(cur);// 保存最近遍历过的节点
                res.add(cur);
                cur = cur.left;
            }else{
                cur = (TreeNode) s1.pop();  // 回头拿到上一个节点
                cur = cur.right;
            }
        }

        for (TreeNode node : res) {
            System.out.print(node.data + " ");
        }
    }

    /**
     * 非递归的中序遍历，利用了 Stack 的特性
     *
     * @param root
     */
    private static void midOrderTraverse_NoRecursion(TreeNode root){
        Stack s1 = new Stack<TreeNode>();
        List<TreeNode> res = new ArrayList<TreeNode>();
        TreeNode cur = root;
        while(cur != null || !s1.isEmpty()){
            if(cur != null){
                s1.push(cur);// 保存最近遍历过的节点
                cur = cur.left; // 先往左到底
            }else{
                cur = (TreeNode) s1.pop(); // 回头拿上一个节点
                res.add(cur);   // 最左子树的中，输出中
                cur = cur.right; // 再往右边
            }
        }

        for (TreeNode node : res) {
            System.out.print(node.data + " ");
        }
    }

    /**
     * 非递归的后序遍历，利用了 Stack 的特性
     *
     * TODO 这实际是 中右左 的顺序遍历，输出时在翻转
     * TODO 这也是一个启示：中右左 可以翻转为 左右中，那么其他顺序也行
     * 前序：中左右 可翻转为 右左中
     * 中序：左中右 可翻转为 右中左
     * 后续：左右中 可翻转为 中右左
     *
     * TODO 所以我们一下子掌握了 6 中遍历的顺序
     *
     * @param root
     */
    private static void postOrderTraverse_NoRecursion(TreeNode root){
        Stack s1 = new Stack<TreeNode>();
        Stack<TreeNode> res = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur != null || !s1.isEmpty()){
            if(cur != null){
                s1.push(cur);// 保存最近遍历过的节点
                res.push(cur); // 先中
                cur = cur.right; // 再右到左，输出就反过来（遍历时按「中右左」的顺序，输出时反过来就是「左右中」）
            }else{
                cur = (TreeNode) s1.pop(); // 回头拿到上一个节点
                cur = cur.left;
            }
        }

        TreeNode node = null;
        while(!res.empty()){ // 从顶部开始输出
            node = res.pop();
            System.out.print(node.data + " ");
        }
    }

    // 另一种的后续遍历，思维会比较顺
    // 第一版本：断开以遍历过的右子树跟父节点的引用。是可行的，但是等于是破坏了树的结构
    // 第二版本：用一个集合标识「已经遍历过右子树的节点」
    private static void postOrderTraverse_NoRecursion2(TreeNode root){
        Stack s1 = new Stack<TreeNode>(); // 类似与我的足迹
        List<TreeNode> res = new ArrayList<TreeNode>();
        List<TreeNode> alreadyTraverse = new ArrayList<TreeNode>();

        TreeNode cur = root;
        while(cur != null || !s1.isEmpty()){
            if(cur != null){
                s1.push(cur);// 保存最近遍历过的节点
                cur = cur.left; // 先往左到底
            }else{
                cur = (TreeNode) s1.peek(); // 回头拿上一个节点

                // 如果该节点有右子树，且没有遍历过，则先遍历其右子树，从而实现了右节点在父节点前被输出
                if(cur.right != null && !alreadyTraverse.contains(cur)){
                    alreadyTraverse.add(cur); // 放入集合，标识这个节点的右子树已经遍历过，等于断开了右子树
                    cur = cur.right; // 右边当作一个新的树
                }else{
                    res.add(cur); // 处理完右子树的节点
                    s1.pop();   // 「我的足迹」不再记录该节点
                    cur = null; // 找上一个节点
                }
            }
        }

        for (TreeNode node : res) {
            System.out.print(node.data + " ");
        }
    }
}
