package Task_2.Task_5;

import javax.xml.bind.JAXBException;

import javax.xml.bind.JAXBException;
import java.util.Collections;
import java.util.List;
// Варіанти на вибір: 1. Оранжерея.

public class Main {
    public static void main(String[] args) {
//        try {
//            JAXBContext context = JAXBContext.newInstance(Flower.class);
//
//            Unmarshaller unmarshaller = context.createUnmarshaller();
//
//            ValidationEventCollector validationEventCollector = new ValidationEventCollector();
//            unmarshaller.setEventHandler(validationEventCollector);
//
//            Flower flower = (Flower) unmarshaller.unmarshal(new File("D:\\КУРС ПО JAVA\\Web-services\\№1. Software setup, web services, XML\\src\\main\\java\\Task_5\\plants.xml"));
//
//            if (validationEventCollector.hasEvents()) {
//                System.out.println("Помилки валідації:");
//                for (ValidationEvent event : validationEventCollector.getEvents()) {
//                    System.out.println(event.getMessage());
//                }
//            } else {
//                System.out.println("XML відповідає XSD-схемі.");
//            }
//
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//        try {
//            Flower flower = FlowerManager.unmarshal("D:\\КУРС ПО JAVA\\Web-services\\№1. Software setup, web services, XML\\src\\main\\java\\Task_5\\plants.xml");
//
//            System.out.println("Розібраний XML:");
//            System.out.println(flower);
//
//
//            FlowerManager.marshal(flower, "D:\\КУРС ПО JAVA\\Web-services\\№1. Software setup, web services, XML\\src\\main\\java\\Task_5\\new_plants.xml");
//
//            System.out.println("Новий XML-документ збережено.");
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }

        try {
            //String filePath = "D:\\КУРС ПО JAVA\\Web-services\\№2. SOAP Web-services concepts, design and implementation\\src\\main\\java\\Task_2\\Task_5\\plants.xml";
            String filePath = "src\\main\\java\\Task_2\\Task_5\\plants.xml";
//            String filePath = "file:///D:/КУРС ПО JAVA/Web-services/№2. SOAP Web-services concepts, design and implementation/src/main/java/Task_2/Task_5/plants.xml";


            List<Plant> plantsDOM = Task_2_XMLParser.parseWithDOM(filePath);
            List<Plant> plantsSAX = Task_2_XMLParser.parseWithSAX(filePath);
            List<Plant> plantsStAX = Task_2_XMLParser.parseWithStAX(filePath);


            Collections.sort(plantsDOM, new Task_2_PlantComparator());
            Collections.sort(plantsSAX, new Task_2_PlantComparator());
            Collections.sort(plantsStAX, new Task_2_PlantComparator());

            System.out.println("Plants parsed with DOM:");
            for (Plant plant : plantsDOM) {
                System.out.println(plant);
            }

            System.out.println("\nPlants parsed with SAX:");
            for (Plant plant : plantsSAX) {
                System.out.println(plant);
            }

            System.out.println("\nPlants parsed with StAX:");
            for (Plant plant : plantsStAX) {
                System.out.println(plant);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}