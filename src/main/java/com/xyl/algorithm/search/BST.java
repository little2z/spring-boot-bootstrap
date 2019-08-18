package com.xyl.algorithm.search;

/**
 * Binary Search Tree  二叉排序树
 */
public class BST {

    private BiTNode root;

    public BiTNode getRoot(){
        return this.root;
    }

    /**
     * 判断指定value的节点是否存在
     * @param target
     * @return
     */
    public boolean isExist(int target){
        return searchBST(root, target) != null;
    }


    /**
     * 从二叉排序树中查找节点的值等于 target 的节点
     * @param target
     * @return
     */
    public BiTNode searchBST(int target){
        return searchBST(root, target);
    }

    /**
     * 从二叉排序树中查找是否存在节点的值等于 target
     * @param target
     * @return
     */
    private BiTNode searchBST(BiTNode tree, int target){
        if(tree == null){
            return null;
        }

        if(target == tree.getData()){
            //查找成功
            return tree;
        }else if(target < tree.getData()){
            //从左子树中查找
            return searchBST(tree.getLeftChild(), target);
        }else {
            //从右子树中查找
            return searchBST(tree.getRightChild(), target);
        }
    }


    /**
     * 插入指定值的节点到二叉排序树中，存在则不动
     * @param target
     */
    public void insertBST(int target){
        root = insertBST(root, target);
    }


    /**
     * 新增指定节点到二叉排序树中，存在则不增加，返回新增之后的root节点
     * @param tree
     * @param target
     */
    private BiTNode insertBST(BiTNode tree, int target){

        if(tree == null){
            //说明树为空
            return new BiTNode(target);
        }

        if(target < tree.getData()){
            //小于当前节点
            tree.setLeftChild(insertBST(tree.getLeftChild(), target));//设置新的左孩子节点

        } else if (target > tree.getData()){
            //大于当前节点
            tree.setRightChild(insertBST(tree.getRightChild(), target));//设置新的右孩子节点
        }

        //和当前节点相等则不操作
        return tree;
    }

    /**
     * 从二叉排序树中删除指定值的节点
     * @param target
     */
    public void deleteBST(int target){
//        root = deleteBST(root, target);
        root = deleteByRecursive(root, target);
    }


    /**
     * 从二叉排序树中删除指定节点
     * @param root
     * @param target
     * @return
     */
    private BiTNode deleteBST(BiTNode root, int target){

        if(root == null){
            return null;
        }

        //需要查找该节点和其父节点
        BiTNode parent = root;
        BiTNode current = root;

        while ( current.getData() != target ){
            parent = current;
            if (current.getData() > target ){
                //继续在当前节点的左子树查找
                current = current.getLeftChild();
            } else {
                //继续在当前节点的右子树查找
                current = current.getRightChild();
            }

            if (current == null) {
                return root;//说明未找到相等节点
            }
        }

        //说明找到了目标节点 current ,此时父节点为 parent，可能是同一个节点

        //如果当前节点是叶子节点
        if(current.getLeftChild() == null && current.getRightChild() == null){
            if(current == root){
                //当前节点是 root 节点
                root = null;
                current = null;
                parent = null;
                return null;
            }

            current = null;
            if(parent.getLeftChild() != null && parent.getLeftChild().getData() == target){
                //说明当前节点是父节点的左孩子
                parent.setLeftChild(null);

            }else{
                parent.setRightChild(null);
            }

        }else if(current.getLeftChild() != null && current.getRightChild() == null ){
            //当前节点只有左孩子
            if(current == root){
                //当前节点是 root 节点
                return current.getLeftChild();//左孩子节点变成根节点
            }

            if(parent.getLeftChild() != null && parent.getLeftChild().getData() == target){
                //说明当前节点是父节点的左孩子
                parent.setLeftChild(current.getLeftChild());

            }else{
                parent.setRightChild(current.getLeftChild());
            }
            current = null;

        }else if(current.getLeftChild() == null && current.getRightChild() != null ){
            //当前节点只有右孩子
            if(current == root){
                //当前节点是 root 节点
                return current.getRightChild();//右孩子节点变成根节点
            }

            if(parent.getLeftChild() != null && parent.getLeftChild().getData() == target){
                //说明当前节点是父节点的左孩子
                parent.setLeftChild(current.getRightChild());

            }else{
                parent.setRightChild(current.getRightChild());
            }
            current = null;

        }else {

            //当前节点的左右孩子节点都存在

            //找出左子树中最大的节点及其父节点
            BiTNode inheriNode = current.getLeftChild();
            BiTNode inheriParentNode = current;


            while (inheriNode.getRightChild() != null){
                inheriParentNode = inheriNode;
                inheriNode = inheriNode.getRightChild();
            }

            current.setData(inheriNode.getData());

            if (inheriNode == current.getLeftChild()){
                //左孩子节点即为左侧最大
                current.setLeftChild(inheriNode.getLeftChild());
            }else {
                //左侧最大值不是左孩子节点
                inheriParentNode.setRightChild(inheriNode.getLeftChild());//将最大值节点的左孩子作为父节点的右孩子
            }

            inheriNode = null;
            inheriParentNode = null;
        }

        return root;
    }

    /**
     * 从二叉排序树 root 中删除指定节点 target
     * @param root
     * @param target
     * @return  返回删除之后新的 root 节点
     */
    private BiTNode deleteByRecursive(BiTNode root, int target){

        if (root == null){
            return null;
        }

        if (root.getData() > target){
            //需要从左子树中删除
            root.setLeftChild(deleteByRecursive(root.getLeftChild(), target));
        }else if (root.getData() < target){
            //需要从右子树中删除
            root.setRightChild(deleteByRecursive(root.getRightChild(), target));
        }else {
            //需要删除根节点
            if (root.getLeftChild() == null){
                //不存在左节点，则直接返回右节点
                return root.getRightChild();
            }

            if (root.getRightChild() == null){
                //不存在右节点，则直接返回左节点
                return root.getLeftChild();
            }

            //当前节点存在左右节点
            BiTNode rChild = root.getRightChild();

            //找出右子树中最小的节点
            BiTNode rMinNode = min(rChild);

            //删除右子树中最小节点后返回右节点
            BiTNode rNewNode = delMin(rChild);

            rMinNode.setRightChild(rNewNode);
            rMinNode.setLeftChild(root.getLeftChild());

            return rMinNode;
        }

        return root;
    }

    /**
     * 返回指定节点中最小的节点
     * @param node
     * @return
     */
    private BiTNode min(BiTNode node){
        if (node.getLeftChild() == null){
            return node;
        }

        return min(node.getLeftChild());
    }

    /**
     * 删除指定节点中最小的节点，并返回删除之后的根节点
     * @param node
     * @return
     */
    private BiTNode delMin(BiTNode node){
        if (node.getLeftChild() == null){
            return node.getRightChild();
        }
        node.setLeftChild(delMin(node.getLeftChild()));
        return node;
    }



    /**
     * 反转当前二叉树
     */
    public void reverse(){
        root = reverse(root);
    }

    /**
     * 反转二叉排序树
     * @param tree
     * @return
     */
    public BiTNode reverse(BiTNode tree){

        if (tree == null){
            return null;
        }

        BiTNode tmp = tree.getLeftChild();
        tree.setLeftChild(reverse(tree.getRightChild()));//设置左节点为反转之后的右节点

        tree.setRightChild(reverse(tmp));//设置右节点为反转之后的右节点

        return tree;
    }




    public static void main(String[] args) {

        int[] array = {33, 88, 12, 99, 20, 9};

        BST bst = new BST();
        for (int i = 0; i <array.length; i++) {
            bst.insertBST(array[i]);
        }

        System.out.println("中序遍历：" + BstUtil.inOrderTraversal(bst.getRoot()));

        System.out.println("是否存在 33 ？" + bst.isExist(33));

        bst.insertBST(50);

        System.out.println("插入 50 之后中序遍历：" + BstUtil.inOrderTraversal(bst.getRoot()));

        bst.insertBST(50);//继续插入50

        System.out.println("再次插入 50 之后中序遍历：" + BstUtil.inOrderTraversal(bst.getRoot()));

        bst.deleteBST(33);//删除根节点

        System.out.println("删除 33 之后中序遍历：" + BstUtil.inOrderTraversal(bst.getRoot()));

        bst.deleteBST(12); //删除只有左子树的节点

        System.out.println("删除 12 之后中序遍历：" + BstUtil.inOrderTraversal(bst.getRoot()));

        bst.deleteBST(20);//删除根节点

        System.out.println("删除 20 之后中序遍历：" + BstUtil.inOrderTraversal(bst.getRoot()));

        bst.reverse();

        System.out.println("反转当前二叉树后中序遍历：" + BstUtil.inOrderTraversal(bst.getRoot()));
    }
}
