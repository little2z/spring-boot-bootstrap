package com.xyl.algorithm.sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort implements Sort {



    public static void main(String[] args) {

        int[] arrays = {3, 5, 2, 10, 9, 1, 0, 8};

        System.out.println("before sort :" + Arrays.toString(arrays));

        Sort sort = new ShellSort();
        sort.sort(arrays);

        System.out.println("after sort :" + Arrays.toString(arrays));
    }

    /**
     * 希尔排序，返回结果从小到大
     * @param arrays
     */
    public void sort(int[] arrays){

        int gap, i, j, temp;

        //gap 为跳跃增量，即分组间隔
        for (gap = arrays.length / 2; gap > 0; gap = gap /2 ){

            //从第 gap 个元素分别对组内进行插入排序
            for (i = gap; i < arrays.length; i++){

                temp = arrays[i];

                for (j = i; j - gap >= 0; j = j-gap){
                    if (arrays[j-gap] > temp){
                        //采用移动排序
                        arrays[j] = arrays[j-gap];
                    }else {
                        break;
                    }
                }

                arrays[j] = temp;//插入当前值
            }
        }

    }

}
