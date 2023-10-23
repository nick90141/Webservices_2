package Task_2.Task_5;

import java.util.Comparator;

public class Task_2_PlantComparator implements Comparator<Plant> {
    @Override
    public int compare(Plant plant1, Plant plant2) {

        return plant1.getName().compareTo(plant2.getName());
    }
}