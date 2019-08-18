package com.xyl;

import lombok.Data;

public class ReferenceTest {


    public static void main(String[] args){

        testCallByValue1();//测试Java方法中基本类型参数传递

        testCallByValue2();//测试Java方法中对象引用传递, 并改变方法中引用指向，结果是不影响调用之前的引用

        testCallByValue3();//测试Java方法中对象引用传递, 并改变方法中引用指向，结果是不影响调用之前的引用

        System.out.println("--------------------------------");

        testCallByValue4();//测试Java方法中对象引用传递，并改变对应引用对象的内容，改变的对象和调用之前的是同一个

    }


    public static void testCallByValue1() {

        int x = 10;
        System.out.println("before update x: "+ x);
        update(x);
        System.out.println("after update x: "+ x);

    }

    private static void update(int value){
        value = 3 * value; //更新value为参数的3倍
    }

    public static void testCallByValue2(){
        InnerClass1 innerClass1 = new InnerClass1("Test");

        InnerClass2 innerClass2 = new InnerClass2(innerClass1);

        System.out.println("before innerClass1 be null, innerClass2 getName " + innerClass2.getName());

        innerClass1 = null;

        //说明 java 中的方法参数为值传递，对于引用类型即是相应引用地址传递
        System.out.println("after innerClass1 be null, innerClass2 getName " + innerClass2.getName());
    }


    public static void testCallByValue3(){

        User zhangsan = new User("zhangsan", 26);
        User lisi = new User("lisi", 18);
        System.out.println("before swap zhangsan:" + zhangsan);
        System.out.println("before swap lisi:" + lisi);
        swap(zhangsan, lisi);
        System.out.println("after swap zhangsan:" + zhangsan);
        System.out.println("after swap lisi:" + lisi);

    }



    private static void swap(User user1, User user2){
        User temp = user1;
        user1 = user2;
        user2 = user1;
    }

    public static void testCallByValue4(){
        User zhangsan = new User("zhangsan", 26);
        System.out.println("before update zhangsan:" + zhangsan);
        updateUser(zhangsan);
        System.out.println("after update zhangsan:" + zhangsan);
    }

    private static void updateUser(User user){
        user.setName("zhangsanUpdate");
        user.setAge(99);
    }

    static class InnerClass1 {

        private String name;

        public InnerClass1(String name){
           this.name = name;
        }

        public String getName(){
            return this.name;
        }
    }

    static class InnerClass2 {

        private InnerClass1 innerClass1;

        public InnerClass2(InnerClass1 innerClass1){
            this.innerClass1 = innerClass1;
        }


        public String getName(){
            return this.innerClass1.getName();
        }
    }

    @Data
    static class User {

        private String name;

        private int age;

        public User(String name, int age){
            this.name = name;
            this.age = age;
        }

    }

}
