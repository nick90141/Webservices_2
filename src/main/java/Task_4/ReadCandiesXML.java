package Task_4;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadCandiesXML {
    public static void main(String[] args) {
        try {
            List<Candy> candies = new ArrayList<>();
            XMLInputFactory factory = XMLInputFactory.newFactory();
            XMLStreamReader reader = factory.createXMLStreamReader(new FileReader("candies.xml"));

            Candy candy = null;
            String elementName = null;

            while (reader.hasNext()) {
                int event = reader.next();

                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        elementName = reader.getLocalName();
                        if ("candy".equals(elementName)) {
                            candy = new Candy();
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        String text = reader.getText().trim();
                        if (!text.isEmpty()) {
                            if ("name".equals(elementName)) {
                                candy.setName(text);
                            } else if ("flavor".equals(elementName)) {
                                candy.setFlavor(text);
                            } else if ("price".equals(elementName)) {
                                candy.setPrice(Double.parseDouble(text));
                            }
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        if ("candy".equals(reader.getLocalName())) {
                            candies.add(candy);
                        }
                        break;
                }
            }

            for (Candy c : candies) {
                System.out.println("Name: " + c.getName());
                System.out.println("Flavor: " + c.getFlavor());
                System.out.println("Price: " + c.getPrice());
                System.out.println();
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

