package dev.sunnysingh.JAXBPlayZone.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;


@Entity
@XmlRootElement(name="transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double amount;

    private String type;
    private OS os;
    // Default constructor is required for JAXB
    public Transaction() {}
    @XmlElement
    public OS getOs() {
        return os;
    }

    public void setOs(OS os) {
        this.os = os;
    }
    public Transaction(Integer id, Double amount, String type, OS os) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.os = os;
    }



    @XmlElement
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlElement
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @XmlElement
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", os=" + os.toString() +
                '}';
    }
}
