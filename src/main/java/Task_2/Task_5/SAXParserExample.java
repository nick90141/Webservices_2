package Task_2.Task_5;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SAXParserExample {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                boolean inPlant = false;
                boolean inName = false;
                boolean inSoil = false;
                boolean inOrigin = false;

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("Plant")) {
                        inPlant = true;
                    } else if (inPlant) {
                        if (qName.equalsIgnoreCase("Name")) {
                            inName = true;
                        } else if (qName.equalsIgnoreCase("Soil")) {
                            inSoil = true;
                        } else if (qName.equalsIgnoreCase("Origin")) {
                            inOrigin = true;
                        }
                    }
                }

                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (inName) {
                        String name = new String(ch, start, length);
                    } else if (inSoil) {
                        String soil = new String(ch, start, length);
                    } else if (inOrigin) {
                        String origin = new String(ch, start, length);
                    }
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if (qName.equalsIgnoreCase("Plant")) {
                        inPlant = false;
                    } else if (inPlant) {
                        if (qName.equalsIgnoreCase("Name")) {
                            inName = false;
                        } else if (qName.equalsIgnoreCase("Soil")) {
                            inSoil = false;
                        } else if (qName.equalsIgnoreCase("Origin")) {
                            inOrigin = false;
                        }
                    }
                }
            };

            File xmlFile = new File("D:\\КУРС ПО JAVA\\Web-services\\№2. SOAP Web-services concepts, design and implementation\\src\\main\\java\\Task_2\\Task_5\\plants.xml");
            saxParser.parse(xmlFile, handler);        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
