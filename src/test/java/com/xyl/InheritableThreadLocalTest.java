package com.xyl;

import java.util.Random;

public class InheritableThreadLocalTest {

    //threadlocal 变量
    private static ThreadLocal<Integer> score = new ThreadLocal<Integer>(){

        @Override
        public Integer initialValue() {
            Random random = new Random();
            return random.nextInt(100);
        }
    };

    //inheritableThreadLocal 变量，子线程可以复制该引用
    private static ThreadLocal<Integer> age = new InheritableThreadLocal<Integer>(){

        @Override
        public Integer initialValue() {
            Random random = new Random();
            return random.nextInt(80);
        }

        public Integer childValue(Integer parentValue) {
            return parentValue + 1;
        }

    };


    public static void main(String args[]){

        System.out.printf("%s 从 ThreadLocal 取数据：%d\n", Thread.currentThread().getName(), score.get());
        System.out.printf("%s 从 InheritableThreadLocal 取数据：%d\n", Thread.currentThread().getName(), age.get());

        //创建新的线程时，会把当前线程中的 inheritableThreadLocals 复制到新创建的线程中
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.printf("%s 从 ThreadLocal 取数据：%d\n", Thread.currentThread().getName(), score.get());   // threadLocals 不会复制
                System.out.printf("%s 从 InheritableThreadLocal 取数据：%d\n", Thread.currentThread().getName(), age.get()); // inheritableThreadLocals 是复制过来的，所以和父线程获取的是同一个

            }
        }, "childThread");

        thread1.start();
    }

}
