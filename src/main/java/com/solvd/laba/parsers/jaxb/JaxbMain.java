package com.solvd.laba.parsers.jaxb;

import com.solvd.laba.parsers.classes.Customer;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class JaxbMain {
    public static void main(String [] args){

        File xmlFile = new File("src/main/resources/parsers/xml/customer.xml");
        try {
            JAXBContext context = JAXBContext.newInstance(Customer.class); //Customer class is top of hierarchy
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Customer customer = (Customer) unmarshaller.unmarshal(xmlFile);
            System.out.println(customer);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }
}
