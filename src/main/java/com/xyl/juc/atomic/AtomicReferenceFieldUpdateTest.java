package com.xyl.juc.atomic;

import lombok.Data;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class AtomicReferenceFieldUpdateTest {

    public static void main(String[] args) {

        AtomicReferenceFieldUpdater<Person, String> nameUpdater = AtomicReferenceFieldUpdater.newUpdater(Person.class, String.class, "name");

        Person person = new Person("张三");

        nameUpdater.compareAndSet(person, "张三", "李四");

        System.out.println(person.getName());

    }

    @Data
    public static class Person{

        volatile String name;

        public Person(String name){
            this.name = name;
        }
    }
}
