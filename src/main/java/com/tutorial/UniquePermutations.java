package com.tutorial;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class UniquePermutations {
    static class Name {
        String firstName;
        String lastName;

        public Name() {
        }

        public Name(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

    }
    static class Person {
        int age;
        Name name;

        public Person() {
        }

        public Person(Name name, int age) {
            this.age = age;
            this.name = name;
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
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    static class FirstNameObject {
        String firstName;

        public FirstNameObject() {
        }

        public FirstNameObject(String firstName) {
            this.firstName = firstName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    static class PersonFullName {
        int age;
        FirstNameObject name;

        public PersonFullName() {
        }

        public PersonFullName(FirstNameObject name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public FirstNameObject getName() {
            return name;
        }

        public void setName(FirstNameObject name) {
            this.name = name;
        }
    }

    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        Person p = new Person(new Name("Manoj", "Chaulagain"), 26);
        System.out.println(mapper.writeValueAsString(mapper.readValue(mapper.writeValueAsBytes(p), PersonFullName.class)));
        mapper.readValue(mapper.writeValueAsString(p), PersonFullName.class);

    }


}
