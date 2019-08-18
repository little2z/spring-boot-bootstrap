package com.xyl.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort implements Sort{


    public static void main(String[] args) {
        int[] arrays = {3, 5, 2, 10, 9, 1, 0, 8, 4};

        System.out.println("before sort :" + Arrays.toString(arrays));

        Sort sort = new QuickSort();
        sort.sort(arrays);

        System.out.println("after sort :" + Arrays.toString(arrays));

    }


    public void sort(int[] arrays){

        if (arrays == null || arrays.length ==0){
            return;
        }

        quickSort(arrays, 0, arrays.length-1);
    }

    public void quickSort(int[] arrays, int start, int end){

        if (start >= end){
            return;
        }

        //找出枢纽值
        int pivot = partition(arrays, start, end);

        //对左侧使用同样方法进行排序
        quickSort(arrays, start, pivot-1);

        //对右侧使用同样方法进行排序
        quickSort(arrays, pivot+1, end);

    }

    /**
     * 采用三数取中的方法找出枢纽值
     * @param arrays
     * @param start
     * @param end
     * @return
     */
    private int partition(int[] arrays, int start, int end) {


        int mid = getPartition(arrays, start, end);

        int pivotKey = arrays[mid];//枢纽值

        int left = start + 1;
        int right = mid;
        while (left < right){

            //因为枢纽值在数组末尾，所以从左侧开始找出第一个比枢纽值大的
            while (left <right && arrays[left] <= pivotKey){
                left++;
            }

            arrays[right] = arrays[left];//将左侧第一个比枢纽值大的值交换

            while (left <right && arrays[right] >= pivotKey){
                //从右侧找到第一个比枢纽值小的
                right--;
            }

            arrays[left] = arrays[right];//将右侧第一个比枢纽值小的交换
        }

        arrays[right] = pivotKey;//将枢纽值最终位置赋值

        return right;
    }


    public int getPartition(int[] arrays, int start, int end){

        int mid = (start + end) / 2;

        if (arrays[start] > arrays[mid]){
            //开始位置大于中间
            swap(arrays, start, mid);
        }

        if (arrays[mid] > arrays[end]){
            //中间位置大于末尾
            swap(arrays, mid, end);
        }

        if (arrays[start] > arrays[mid]){
            //开始位置大于中间
            swap(arrays, start, mid);
        }

        swap(arrays, mid, end-1);//将枢纽值放在数组末尾倒数第二个

        return end-1;
    }


    /**
     * 使用中间变量交换两个元素
     * @param array
     * @param i
     * @param j
     */
    public void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }



}
