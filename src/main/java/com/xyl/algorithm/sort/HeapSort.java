package com.xyl.algorithm.sort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort implements Sort {


    public static void main(String[] args) {

        int[] arrays = {3, 5, 2, 10, 9, 1, 0, 8};

        System.out.println("before sort :" + Arrays.toString(arrays));

        Sort sort = new HeapSort();
        sort.sort(arrays);

        System.out.println("after sort :" + Arrays.toString(arrays));
    }


    /**
     * 堆排序，返回结果从小到大
     * @param arrays
     */
    public void sort(int[] arrays){

        int i;
        //先构造一个初始大顶堆
        for (i = arrays.length / 2; i >= 0; i--){
            heapAdjust(arrays, i, arrays.length);//将这个数组理解为一颗完全二叉树，从下往上，从右往左，从第一个非叶子节点开始和左右孩子节点比较
        }

        for (i = arrays.length-1; i > 0; i--){
            swap(arrays, 0, i);//将堆顶元素和最后一个元素进行交换

            heapAdjust(arrays, 0, i);//除掉交换的末尾之外，剩余的元素继续调整构造一个大顶堆
        }

    }

    /**
     * 调整数组指定范围的元素构成一个大顶堆，包含start, 不包含end
     * @param arrays
     * @param start
     * @param end
     */
    public void heapAdjust(int[] arrays, int start, int end){

        int j;
        int temp = arrays[start];//以该节点为根节点
        for (j = start * 2; j < end; j = j * 2){//利用完全二叉树的性质，父亲节点为 i, 左右节点序号分别为 2i, 2i+1

            if ( (j + 1) < end && arrays[j] < arrays[j + 1]){
                j++;  // j 指向孩子节点中较大的一个
            }

            if (temp >= arrays[j]){//当前位置正确
                break;
            }

            //当前根节点比较大的孩子节点小，则将较大的孩子节点当做根节点
            arrays[start] = arrays[j];
            start = j;
        }

        arrays[start] = temp;//将传入的节点放置合适的位置
    }

}
