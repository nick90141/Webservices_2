package Task_2.Task_5;

import javax.xml.bind.annotation.XmlElement;

public class GrowingTips {
    private String temperature;
    private String lighting;
    private String watering;

    public String getTemperature() {
        return temperature;
    }

    @XmlElement
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getLighting() {
        return lighting;
    }

    @XmlElement
    public void setLighting(String lighting) {
        this.lighting = lighting;
    }

    public String getWatering() {
        return watering;
    }

    @XmlElement
    public void setWatering(String watering) {
        this.watering = watering;
    }

    @Override
    public String toString() {
        return "GrowingTips{" +
                "temperature='" + temperature + '\'' +
                ", lighting='" + lighting + '\'' +
                ", watering='" + watering + '\'' +
                '}';
    }
}
