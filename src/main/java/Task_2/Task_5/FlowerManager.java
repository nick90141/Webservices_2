package Task_2.Task_5;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;


public class FlowerManager {
    public static Flower unmarshal(String xmlFileName) throws JAXBException {
        File xmlFile = new File(xmlFileName);
        JAXBContext context = JAXBContext.newInstance(Flower.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Flower) unmarshaller.unmarshal(xmlFile);
    }

    public static void marshal(Flower flower, String xmlFileName) throws JAXBException {
        File xmlFile = new File(xmlFileName);
        JAXBContext context = JAXBContext.newInstance(Flower.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(flower, xmlFile);
    }
}