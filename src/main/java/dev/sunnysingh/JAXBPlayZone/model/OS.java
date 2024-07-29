package dev.sunnysingh.JAXBPlayZone.model;

import jakarta.persistence.Embeddable;
import jakarta.xml.bind.annotation.XmlElement;

@Embeddable
public class OS {
    private String version;
    private String name;
    @XmlElement
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OS{" +
                "version='" + version + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
