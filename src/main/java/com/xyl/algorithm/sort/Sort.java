package com.xyl.algorithm.sort;

public interface Sort {

    void sort(int[] arrays);


    /**
     * 使用中间变量交换两个元素
     * @param array
     * @param i
     * @param j
     */
    default void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    /**
     * 不使用中间变量交换两个元素
     * @param array
     * @param i
     * @param j
     */
    default void swapBySelf(int[] array, int i, int j){
        array[i] = array[i] + array[j];
        array[j] = array[i] - array[j];
        array[i] = array[i] - array[j];
    }
}
