package Vladislav.Osipenkov;

import nu.xom.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 21cmPC on 13.09.2016.
 * Open file Data.inf and parse it.
 */
public class XmlParser {
    public static void main(String[] args) throws ParsingException, IOException {
        File file = new File("D:\\learn\\TryXomXML\\XOMParser\\XOMParser\\Data.inf");
        Document document = new Builder().build(file.getAbsoluteFile());
        Elements people = document.getRootElement().getChildElements();

        List<Person> result = new ArrayList<Person>();
        for (int i = 0; i < people.size(); i++) {
            result.add(new Person(people.get(i)));
        }

        System.out.println(result);
    }
}
