package Vladislav.Osipenkov;

import nu.xom.*;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/**
 * Created by 21cmPC on 13.09.2016.
 */
public class Person {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(Element root) {
        firstName = root.getFirstChildElement("firstName").toString();
        lastName = root.getFirstChildElement("lastName").toString();
    }

    public static void toXml(OutputStream out, Document document) {
        try {
            Serializer serializer = new Serializer(out, "ISO-8859-1");
            serializer.setMaxLength(60);
            serializer.setIndent(4);
            serializer.write(document);
            serializer.flush();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
