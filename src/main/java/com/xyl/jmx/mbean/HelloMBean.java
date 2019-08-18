package com.xyl.jmx.mbean;


/**
 * 接口的命名规范为以具体的实现类为前缀 + MBean
 */
public interface HelloMBean {


    String getName();

    void setName(String name);

    Integer getAge();

    void setAge(Integer age);

    void helloWorld();

    void helloWorld(String name);


    String getTelephone();

}
