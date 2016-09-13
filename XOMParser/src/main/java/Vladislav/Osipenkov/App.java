package Vladislav.Osipenkov;

import nu.xom.Document;
import nu.xom.Element;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;

/**
 * XOMParser, this class needs to write in xml using XOM lib.
 */
public class App {
    public static void main(String[] args) throws FileNotFoundException {
        List<Person> persons = Arrays.asList(
                new Person("Vlad", "Osipenkov"),
                new Person("Alex", "Mutex"),
                new Person("Mr", "Anderson")
        );

        System.out.println(persons);
        System.out.println("******");

        Element people = new Element("people");
        for (Person item : persons) {
            people.appendChild(item.getXml());
        }
        Document document = new Document(people);

        Person.toXml(System.out, document);

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("Data.inf"));
        Person.toXml(bufferedOutputStream, document);
    }
}
