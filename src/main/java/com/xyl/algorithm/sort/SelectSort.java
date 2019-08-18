package com.xyl.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectSort  implements Sort {


    public static void main(String[] args) {

        int[] arrays = {3, 5, 2, 10, 9, 1, 0, 8};

        System.out.println("before sort :" + Arrays.toString(arrays));

        Sort sort = new SelectSort();
        sort.sort(arrays);

        System.out.println("after sort :" + Arrays.toString(arrays));
    }

    /**
     * 选择排序,结果为从小到大
     * @param arrays
     */
    public void sort(int[] arrays){

        int i, j,min;
        for (i = 0; i < arrays.length; i++) {

            min = i;
            for (j = i + 1; j < arrays.length; j++ ){
                if (arrays[min] > arrays[j]){
                    //选出最小的
                    min = j;
                }
            }

            if (min != i){
                //当前不是最小的，则需要和最小值交换
                swap(arrays, i, min);
            }

        }
    }


}
