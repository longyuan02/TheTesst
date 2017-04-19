package com.mazhan.theone.dogger;

/**
 * Created by dragonfly on 2017/4/12.
 */

public class Person {
    private int age;
    private String name;

    public Person() {

    }

    public Person(int ages, String names) {
        this.age = ages;
        this.name = names;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
