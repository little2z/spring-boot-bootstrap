package com.xyl.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序，时间复杂度为 O(nlogn)
 */
public class MergeSort implements Sort {


    public static void main(String[] args) {

        int[] arrays = {3, 5, 2, 10, 9, 1, 0, 8};

        System.out.println("before sort :" + Arrays.toString(arrays));

        Sort sort = new MergeSort();
        sort.sort(arrays);

        System.out.println("after sort :" + Arrays.toString(arrays));
    }


    public void sort(int[] arrays){

        if (arrays == null || arrays.length <= 0){
            return;
        }

        int[] temp = new int[arrays.length];

//        sort(arrays, 0, arrays.length-1, temp);
        sortNonRecursive(arrays, 0, arrays.length-1, temp);
    }

    /**
     * 使用递归方法进行归并排序
     * @param arrays    待排序数组
     * @param left      待排序开始位置
     * @param right     待排序结束位置
     * @param temp      临时数组
     */
    private void sort(int[] arrays, int left, int right, int[] temp) {

        if (left >= right){
            return;
        }

        int mid = (left + right)/2;

        //将左边序列进行排序
        sort(arrays, left, mid, temp);

        //将右边序列进行排序
        sort(arrays, mid+1, right, temp);

        //合并左右两个有序序列
        merge(arrays, left, mid, right, temp);

    }


    /**
     * 非递归归并排序，从长度为1开始，将两个有序子序列合并，一直到整个数组长度
     * @param arrays
     * @param left
     * @param right
     * @param temp
     */
    private void sortNonRecursive(int[] arrays, int left, int right, int[] temp){

        int len = 1;
        int arrayLength = arrays.length;

        int start, mid, end;
        while (arrayLength > len){

            for (int i = 0;  i + len < arrayLength; i += 2 * len){
                start = i;                //序列长度为len 左序列的起始位置
                mid = start + len -1;     //序列长度为len 左序列的结束位置
                end = start + 2 * len -1; //序列长度为len 右序列的结束位置

                if (end > arrayLength-1){
                    end = arrayLength-1; //防止超出数组
                }

                merge(arrays, start, mid, end, temp);//合并长度为 len 的有序左右子序列
            }

            len *= 2;//将有序序列长度扩大一倍再进行合并
        }

    }



    /**
     * 合并两个有序列表
     * @param arrays   待合并数组
     * @param left     待合并左序列起始位置
     * @param mid      待合并左序列结束位置（即右序列起始位置为 mid+1）
     * @param right    待合并右序列结束位置
     * @param temp
     */
    private void merge(int[] arrays, int left, int mid, int right, int[] temp) {

        int i = left;//左序列指针
        int j = mid +1; //右序列指针

        int t = 0; //临时数组指针

        while (i <= mid && j <= right){//将左右序列中的元素从左到右比较大小存储到临时数组
            if (arrays[i] < arrays[j]){
                temp[t++] = arrays[i++];
            }else {
                temp[t++] = arrays[j++];
            }
        }

        while (i <= mid){//将左序列剩余元素添加到 temp
            temp[t++] = arrays[i++];
        }

        while (j <= right){//将右序列剩余元素添加到 temp
            temp[t++] = arrays[j++];
        }

        t = 0;
        while (left <= right){
            //将排好序的temp 数组元素存储到原数组位置
            arrays[left++] = temp[t++];
        }

    }


}
