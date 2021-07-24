package com.tutorial.models;

import com.fasterxml.jackson.annotation.JsonFilter;

import java.util.ArrayList;
import java.util.List;

//@JsonFilter("firstNameFilter")
public class Person {
    private int age;
    private Name name;

    private List<Person> children;

    public Person() {
        this.children = new ArrayList<>();
    }

    public Person(Name name, int age) {
        this.age = age;
        this.name = name;
        this.children = new ArrayList<>();
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }
}
