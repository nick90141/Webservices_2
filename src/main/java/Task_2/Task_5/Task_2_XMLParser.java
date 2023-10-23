package Task_2.Task_5;
import org.w3c.dom.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.*;
import javax.xml.stream.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Task_2_XMLParser {
    public static List<Plant> parseWithDOM(String filePath) throws Exception {
        List<Plant> plants = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(filePath));

        NodeList plantNodes = document.getElementsByTagName("Plant");
        for (int i = 0; i < plantNodes.getLength(); i++) {
            Element plantElement = (Element) plantNodes.item(i);
            Plant plant = new Plant();
            plant.setName(plantElement.getElementsByTagName("Name").item(0).getTextContent());
            plant.setSoil(plantElement.getElementsByTagName("Soil").item(0).getTextContent());
            plant.setOrigin(plantElement.getElementsByTagName("Origin").item(0).getTextContent());
            plants.add(plant);
        }

        return plants;
    }

    public static List<Plant> parseWithSAX(String filePath) throws Exception {
        List<Plant> plants = new ArrayList<>();

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        DefaultHandler handler = new DefaultHandler() {
            Plant plant;
            String currentElement;

            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if ("Plant".equals(qName)) {
                    plant = new Plant();
                }
                currentElement = qName;
            }

            public void characters(char[] ch, int start, int length) throws SAXException {
                if (plant != null) {
                    String value = new String(ch, start, length);
                    if ("Name".equals(currentElement)) {
                        plant.setName(value);
                    } else if ("Soil".equals(currentElement)) {
                        plant.setSoil(value);
                    } else if ("Origin".equals(currentElement)) {
                        plant.setOrigin(value);
                    }
                }
            }

            public void endElement(String uri, String localName, String qName) throws SAXException {
                if ("Plant".equals(qName)) {
                    plants.add(plant);
                    plant = null;
                }
            }
        };

        saxParser.parse(filePath, handler);
        return plants;
    }

    public static List<Plant> parseWithStAX(String filePath) throws Exception {
        List<Plant> plants = new ArrayList<>();

        XMLInputFactory factory = XMLInputFactory.newFactory();
        XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(filePath));

        Plant plant = null;
        String currentElement = null;

        while (reader.hasNext()) {
            int event = reader.next();

            if (event == XMLStreamConstants.START_ELEMENT) {
                currentElement = reader.getLocalName();
                if ("Plant".equals(currentElement)) {
                    plant = new Plant();
                }
            } else if (event == XMLStreamConstants.CHARACTERS && plant != null) {
                String value = reader.getText();
                if ("Name".equals(currentElement)) {
                    plant.setName(value);
                } else if ("Soil".equals(currentElement)) {
                    plant.setSoil(value);
                } else if ("Origin".equals(currentElement)) {
                    plant.setOrigin(value);
                }
            } else if (event == XMLStreamConstants.END_ELEMENT && "Plant".equals(currentElement)) {
                plants.add(plant);
                plant = null;
            }
        }

        return plants;
    }
}