package com.xyl.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort implements Sort{

    public static void main(String[] args) {

        int[] arrays = {3, 5, 2, 10, 9, 1, 0, 8};

        System.out.println("before sort :" + Arrays.toString(arrays));

        Sort sort = new InsertSort();
        sort.sort(arrays);

        System.out.println("after sort :" + Arrays.toString(arrays));
    }


    /**
     * 插入排序，返回结果从小到大
     * @param arrays
     */
    public void sort(int[] arrays){

        int i, j, temp;

        for (i = 1; i < arrays.length; i++){

            temp = arrays[i];
            for (j = i; j > 0; j--){

                if (arrays[j-1] > temp){
                    //前者比当前值大，则往后移动一位
                    arrays[j] = arrays[j-1];

                }else{
                    break;//说明找到当前值插入的位置
                }

            }

            if ( j != i){
                arrays[j] = temp;//插入当前值
            }
        }

    }


}
