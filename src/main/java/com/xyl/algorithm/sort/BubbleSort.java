package com.xyl.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort implements Sort {


    public static void main(String[] args) {

        int[] arrays = {3, 5, 2, 10, 9, 1, 0, 8};

        System.out.println("before sort :" + Arrays.toString(arrays));

        Sort sort = new BubbleSort();
        sort.sort(arrays);

        System.out.println("after sort :" + Arrays.toString(arrays));
    }

    /**
     * 使用冒泡排序，最后结果为从小到大
     * @param arrays
     */
    public void sort(int[] arrays){

        boolean isOver = false;
        for (int i = 0; i < arrays.length && !isOver; i ++) {
            isOver = true;
            for (int j = arrays.length - 2; j >= i; j--){
                if( arrays[j] > arrays[j+1]){
                    //左边大于右边，则将小的往前放
                    swap(arrays, j, j+1);
                    isOver = false;
                }
            }
        }
    }

}
