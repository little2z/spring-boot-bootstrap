package com.xyl.algorithm.search;

public class SequentialSearch {

    /**
     * 顺序查找 target 在目标数组中的位置，不存在则返回 -1
     * @param array
     * @param target
     * @return
     */
    public static int sequentialSearch(int[] array, int target){

        for (int i = 0; i < array.length; i++) {
            if(array[i] == target){
                return i;
            }
        }
        
        return -1;
    }

    /**
     * 哨兵顺序查找，第一个位置需要留空，查找成功返回相应下标，失败返回第一个位置0
     * @param array
     * @param target
     * @return
     */
    public  static int sentinelSearch(int[] array, int target){

        array[0] = target;
        int len = array.length - 1;

        while(array[len] != target){
            len--;
        }

        return len;
    }

    public static void main(String[] args) {

        int[] array = {1, 5, 200, 99, 80, 50, 20};

        int target = 50;
//        int result = sequentialSearch(array, target);
        int result = sentinelSearch(array, target);

        System.out.println("search result " + result);

    }


    public static int searchFirstGreaterValue(int[] array, int target){

        for (int i = 0; i < array.length; i++) {
            if (array[i] > target){
                return i;
            }
        }
        return -1;
    }


}
