package com.solvd.laba.parsers.stax;

import com.solvd.laba.parsers.classes.Customer;
import com.solvd.laba.parsers.classes.Transaction;
import com.solvd.laba.parsers.classes.Account;
import com.solvd.laba.parsers.classes.Statement;
import com.solvd.laba.parsers.classes.Loan;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.transform.stax.StAXSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StaxMain {
    public static void main(String [] args){
        File xmlFile = new File("src/main/resources/parsers/xml/customer.xml");
        File xsdFile = new File("src/main/resources/parsers/xml/customer.xsd");
        //STAX psrser
        validateXML(xmlFile, xsdFile);

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try (FileInputStream fileInputStream = new FileInputStream(xmlFile)){
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(fileInputStream);

            Customer customer = null;
            Transaction transaction = null;
            Account account = null;
            Statement statement = null;
            Loan loan = null;

            List<Transaction> transactions = new ArrayList<>();
            List<Account> accounts = new ArrayList<>();
            List<Statement> statements = new ArrayList<>();
            List<Loan> loans = new ArrayList<>();

            while (reader.hasNext()){
                XMLEvent event = reader.nextEvent();
                if (event.isStartElement()){
                    StartElement startElement = event.asStartElement();
                    String elementName = startElement.getName().getLocalPart();
//                    System.out.println("Start Element --> " + elementName);
                    switch (elementName) {
                        case "customer":
                            customer = new Customer();
                            customer.setId(Long.parseLong(startElement.getAttributeByName(new QName("id")).getValue())); //QName
                            break;
                        case "name":
                            customer.setName(reader.getElementText());
                            break;
                        case "phoneNumber":
                            customer.setPhoneNumber(reader.getElementText());
                            break;
                        case "transaction":
                            transaction = new Transaction();
                            transaction.setId(Long.parseLong(startElement.getAttributeByName(new QName("id")).getValue()));
                            break;
                        case "amount":
                            transaction.setAmount(Double.parseDouble(reader.getElementText()));
                            break;
                        case "transactionType":
                            transaction.setType(reader.getElementText());
                            break;
                        case "date":
                            transaction.setDate(LocalDate.parse(reader.getElementText()));
                            break;
                        case "account":
                            account = new Account();
                            account.setId(Long.parseLong(startElement.getAttributeByName(new QName("id")).getValue()));
                            statements = new ArrayList<>();
                            break;
                        case "balance":
                            account.setBalance(Double.parseDouble(reader.getElementText()));
                            break;
                        case "accountType":
                            account.setType(reader.getElementText());
                            break;
                        case "AccountOpenDate":
                            account.setOpenDate(LocalDate.parse(reader.getElementText()));
                            break;
                        case "statement":
                            statement = new Statement();
                            statement.setId(Long.parseLong(startElement.getAttributeByName(new QName("id")).getValue()));
                            break;
                        case "startBalance":
                            statement.setStartBalance(Double.parseDouble(reader.getElementText()));
                            break;
                        case "endBalance":
                            statement.setEndBalance(Double.parseDouble(reader.getElementText()));
                            break;
                        case "openDate":
                            statement.setOpenDate(LocalDate.parse(reader.getElementText()));
                            break;
                        case "endDate":
                            statement.setEndDate(LocalDate.parse(reader.getElementText()));
                            break;
                        case "loan":
                            loan = new Loan();
                            loan.setId(Long.parseLong(startElement.getAttributeByName(new QName("id")).getValue()));
                            break;
                        case "loanAmount":
                            loan.setAmount(Double.parseDouble(reader.getElementText()));
                            break;
                        case "interestRate":
                            loan.setInterestRate(Double.parseDouble(reader.getElementText()));
                            break;
                        case "loanType":
                            loan.setType(reader.getElementText());
                            break;
                        case "startDate":
                            loan.setStartDate(LocalDate.parse(reader.getElementText()));
                            break;
                        case "closeDate":
                            loan.setEndDate(LocalDate.parse(reader.getElementText()));
                            break;
                    }
                }
                else if (event.isEndElement()) {
                    String elementName = event.asEndElement().getName().getLocalPart();
//                    System.out.println("End Element --> " + elementName);
                    switch (elementName) {
                        case "customer":
                            customer.setTransactions(transactions);
                            customer.setAccounts(accounts);
                            customer.setLoans(loans);
                            break;
                        case "transaction":
                            transactions.add(transaction);
                            break;
                        case "account":
                            account.setStatements(statements);
                            accounts.add(account);
                            break;
                        case "statement":
                            statements.add(statement);
                            break;
                        case "loan":
                            loans.add(loan);
                            break;
                    }
                }
            }
            System.out.println(customer);

        } catch (IOException | XMLStreamException e) {
            throw new RuntimeException(e);
        }

    }

    private static void validateXML(File xmlFile, File xsdFile) {
        XMLStreamReader reader = null;
        try {
            reader = XMLInputFactory.newInstance().createXMLStreamReader(new FileInputStream(xmlFile));
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(xsdFile);
            Validator validator = schema.newValidator();
            validator.validate(new StAXSource(reader));
            System.out.println("XML and XSD looks good");
        } catch (XMLStreamException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
