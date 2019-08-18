package com.xyl.algorithm.search;

import java.util.ArrayList;
import java.util.List;

public class BstUtil {


    /**
     * 前序遍历二叉树
     * @param tree
     */
    public static List<Integer> preOrderTraversal(BiTNode tree){

        if(tree == null){
            return null;
        }

        List<Integer> result = new ArrayList<>();
        result.add(tree.getData());

        List<Integer> left = preOrderTraversal(tree.getLeftChild());
        if(left != null && left.size() > 0){
            result.addAll(left);
        }

        List<Integer> right = preOrderTraversal(tree.getRightChild());
        if(right != null && right.size() > 0){
            result.addAll(right);
        }

        return result;
    }


    /**
     * 中序遍历二叉树
     * @param tree
     */
    public static List<Integer> inOrderTraversal(BiTNode tree){

        if(tree == null){
            return null;
        }

        List<Integer> result = new ArrayList<>();

        List<Integer> left = inOrderTraversal(tree.getLeftChild());
        if(left != null && left.size() > 0){
            result.addAll(left);
        }

        result.add(tree.getData());

        List<Integer> right = inOrderTraversal(tree.getRightChild());
        if(right != null && right.size() > 0){
            result.addAll(right);
        }

        return result;
    }

    /**
     * 后序遍历二叉树
     * @param tree
     */
    public static List<Integer> postOrderTraversal(BiTNode tree){

        if(tree == null){
            return null;
        }

        List<Integer> result = new ArrayList<>();

        List<Integer> left = inOrderTraversal(tree.getLeftChild());
        if(left != null && left.size() > 0){
            result.addAll(left);
        }

        List<Integer> right = inOrderTraversal(tree.getRightChild());
        if(right != null && right.size() > 0){
            result.addAll(right);
        }

        result.add(tree.getData());

        return result;
    }

    /**
     * 打印树
     * @param root
     * @return
     */
    public static String printTree(BiTNode root){

        if ( root == null){
            return null;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.getData());

        String left = printTree(root.getLeftChild());
        if(left != null){
            sb.append("\n");//换行
            sb.append("  /");//边
            sb.append(left);//值
        }

        String right = printTree(root.getRightChild());
        if(right != null){
            sb.append("\n");//换行
            sb.append("  \\");//边
            sb.append(right);//值
        }

        return sb.toString();
    }
}
