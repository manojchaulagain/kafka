package com.tutorial;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.tutorial.models.Name;
import com.tutorial.models.Person;
import scala.Int;

import java.io.IOException;

public class ObjectFilter {

    private static ObjectMapper mapper = new ObjectMapper();

    private static boolean addFilter = false;

    public static void main(String[] args) throws IOException {
        Person p = createP("Manoj", "Chaulagain", 26);
        for (int i = 0; i < 10; i++) {
            p.getChildren().add(createP("Manoj " + i, "Chaulagain " + i, 26 * i));
        }


        SimpleFilterProvider filters = new SimpleFilterProvider();
        if (addFilter) {
            filters.addFilter(
                    "firstNameFilter", SimpleBeanPropertyFilter.serializeAllExcept("lastName"));

        } else {
            filters.setFailOnUnknownId(false);
        }

        String jsonString = mapper.writer(filters)
                .withDefaultPrettyPrinter()
                .writeValueAsString(p);
        System.out.println(jsonString);

    }

    public static Person createP(String fname, String lname, int age) {
        return new Person(new Name(fname, lname), age);
    }


}
