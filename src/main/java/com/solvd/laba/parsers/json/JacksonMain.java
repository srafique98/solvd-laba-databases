package com.solvd.laba.parsers.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.laba.parsers.classes.Customer;

import java.io.File;
import java.io.IOException;

public class JacksonMain {
    public static void main(String [] args){
        File jsonFile = new File("src/main/resources/parsers/json/customer.json");
        ObjectMapper mapper = new ObjectMapper();
        try {
            Customer customer = mapper.readValue(jsonFile, Customer.class); // Customer class us top of hierarchy
            System.out.println(customer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
