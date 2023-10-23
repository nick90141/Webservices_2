package Task_4;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;

public class CreateCandiesXML {
    public static void main(String[] args) {
        try {
            XMLOutputFactory factory = XMLOutputFactory.newFactory();
            XMLStreamWriter writer = factory.createXMLStreamWriter(new FileOutputStream("candies.xml"));

            writer.writeStartDocument();

            writer.writeStartElement("factory");

            addCandy(writer, "Chocolate Bar", "Chocolate", 1.5);
            addCandy(writer, "Lollipop", "Cherry", 0.5);
            addCandy(writer, "Gummy Bears", "Mixed Fruit", 1.0);

            writer.writeEndElement();

            writer.writeEndDocument();

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addCandy(XMLStreamWriter writer, String name, String flavor, double price) throws Exception {
        writer.writeStartElement("candy");

        writer.writeStartElement("name");
        writer.writeCharacters(name);
        writer.writeEndElement();

        writer.writeStartElement("flavor");
        writer.writeCharacters(flavor);
        writer.writeEndElement();

        writer.writeStartElement("price");
        writer.writeCharacters(Double.toString(price));
        writer.writeEndElement();

        writer.writeEndElement();
    }
}
