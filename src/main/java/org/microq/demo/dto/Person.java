package org.microq.demo.dto;


import java.io.Serializable;

public class Person implements Serializable {

    private String name;
    private Integer age;
    private String nationality;

    public Person() {
    }

    public Person(String name, Integer age, String nationality) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
