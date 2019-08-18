package com.xyl.jmx.mbean;


/**
 * 该类名称必须与实现的接口的前缀保持一致（即MBean前面的名称)
 */
public class Hello implements HelloMBean {

    private String name;

    private Integer age;

    @Override
    public String getName() {

        System.out.println("getName:" + this.name);
        return this.name;
    }

    @Override
    public void setName(String name) {

        System.out.println("setName:" + name);
        this.name = name;

    }

    @Override
    public Integer getAge() {
        System.out.println("getAge:" + this.age);
        return this.age;
    }

    @Override
    public void setAge(Integer age) {
        System.out.println("setAge:" + age);
        this.age = age;
    }

    @Override
    public void helloWorld() {
        System.out.println("hello World");
    }

    @Override
    public void helloWorld(String name) {
        System.out.println("hello World, " + name);
    }

    @Override
    public String getTelephone() {

        System.out.println("getTelephone");
        return "110";
    }

}
