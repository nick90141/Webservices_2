package Task_2.Task_5;

import javax.xml.bind.annotation.XmlElement;

public class VisualParameters {
    private String stemColor;
    private String leafColor;
    private String size;

    public String getStemColor() {
        return stemColor;
    }

    @XmlElement
    public void setStemColor(String stemColor) {
        this.stemColor = stemColor;
    }

    public String getLeafColor() {
        return leafColor;
    }

    @XmlElement
    public void setLeafColor(String leafColor) {
        this.leafColor = leafColor;
    }

    public String getSize() {
        return size;
    }

    @XmlElement
    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "VisualParameters{" +
                "stemColor='" + stemColor + '\'' +
                ", leafColor='" + leafColor + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
