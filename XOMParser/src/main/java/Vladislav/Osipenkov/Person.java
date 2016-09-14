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
    private String addressInfo;

    public Person(String firstName, String lastName, String addressInfo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressInfo = addressInfo;
    }

    public Person(Element root) {
        firstName = root.getFirstChildElement("firstName").getValue();
        lastName = root.getFirstChildElement("lastName").getValue();
        addressInfo = root.getFirstChildElement("addressInfo").getValue();
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

    public Element getXml() {
        Element root = new Element("Person");
        Element firstNameElem = new Element("firstName");
        Element lastNameElem = new Element("lastName");
        Element addressElem = new Element("addressInfo");

        firstNameElem.appendChild(firstName);
        lastNameElem.appendChild(lastName);
        addressElem.appendChild(addressInfo);

        root.appendChild(firstNameElem);
        root.appendChild(lastNameElem);
        root.appendChild(addressElem);

        return root;
    }

    public String toString() {
        return firstName + " " + lastName + " " +addressInfo;
    }
}
