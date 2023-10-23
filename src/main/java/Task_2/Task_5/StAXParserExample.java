package Task_2.Task_5;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;

public class StAXParserExample {
    public static void main(String[] args) {
        try {
            XMLInputFactory factory = XMLInputFactory.newFactory();
            FileInputStream fileInputStream = new FileInputStream("D:\\КУРС ПО JAVA\\Web-services\\№2. SOAP Web-services concepts, design and implementation\\src\\main\\java\\Task_2\\Task_5\\plants.xml");
            XMLStreamReader reader = factory.createXMLStreamReader(fileInputStream);

            while (reader.hasNext()) {
                int event = reader.next();
                if (event == XMLStreamConstants.START_ELEMENT) {
                    if ("Plant".equals(reader.getLocalName())) {
                    }
                }
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
