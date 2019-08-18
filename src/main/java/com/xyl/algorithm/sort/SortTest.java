package com.xyl.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class SortTest {

    public static void main(String[] args) {

        int length = 1000000;
        int[] arrays = new int[length];

        Random random = new Random();

        for (int i = 0; i < arrays.length; i++){
            arrays[i] = random.nextInt() * length;
        }


        int[] sortArray = Arrays.copyOf(arrays, arrays.length);
        Long start = System.currentTimeMillis();

        Sort sort = new BubbleSort();
//        sort.sort(sortArray);

        System.out.println(String.format("冒泡排序 %d 个元素，耗时 %s ms", sortArray.length,  (System.currentTimeMillis() - start)));

        sortArray = Arrays.copyOf(arrays, arrays.length);
        start = System.currentTimeMillis();

        sort = new SelectSort();
//        sort.sort(sortArray);

        System.out.println(String.format("选择排序 %d 个元素，耗时 %s ms", sortArray.length,  (System.currentTimeMillis() - start)));


        sortArray = Arrays.copyOf(arrays, arrays.length);
        start = System.currentTimeMillis();

        sort = new InsertSort();
//        sort.sort(sortArray);

        System.out.println(String.format("插入排序 %d 个元素，耗时 %s ms", sortArray.length,  (System.currentTimeMillis() - start)));


        sortArray = Arrays.copyOf(arrays, arrays.length);
        start = System.currentTimeMillis();

        sort = new ShellSort();
        sort.sort(sortArray);

        System.out.println(String.format("希尔排序 %d 个元素，耗时 %s ms", sortArray.length,  (System.currentTimeMillis() - start)));

        sortArray = Arrays.copyOf(arrays, arrays.length);
        start = System.currentTimeMillis();

        sort = new HeapSort();
        sort.sort(sortArray);

        System.out.println(String.format("  堆排序 %d 个元素，耗时 %s ms", sortArray.length,  (System.currentTimeMillis() - start)));

        sortArray = Arrays.copyOf(arrays, arrays.length);
        start = System.currentTimeMillis();

        sort = new MergeSort();
        sort.sort(sortArray);

        System.out.println(String.format("归并排序 %d 个元素，耗时 %s ms", sortArray.length,  (System.currentTimeMillis() - start)));


        sortArray = Arrays.copyOf(arrays, arrays.length);
        start = System.currentTimeMillis();

        sort = new QuickSort();
        sort.sort(sortArray);

        System.out.println(String.format("快速排序 %d 个元素，耗时 %s ms", sortArray.length,  (System.currentTimeMillis() - start)));
    }

}
