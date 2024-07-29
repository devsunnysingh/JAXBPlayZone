package dev.sunnysingh.JAXBPlayZone.service;

import dev.sunnysingh.JAXBPlayZone.model.Transaction;
//import dev.sunnysingh.JAXBPlayZone.repository.XMLToJavaRepository;
import dev.sunnysingh.JAXBPlayZone.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.StringReader;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction convertXMLToJavaObject(String xmlData) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Transaction.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (Transaction) unmarshaller.unmarshal(new StringReader(xmlData));
        } catch (JAXBException e) {
            System.out.println("Exception occurred: " + e);
            return null;
        }
    }

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
