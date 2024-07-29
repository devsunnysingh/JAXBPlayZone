package dev.sunnysingh.JAXBPlayZone.controller;

import dev.sunnysingh.JAXBPlayZone.model.Transaction;
import dev.sunnysingh.JAXBPlayZone.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class XMLToDBController {
    @Autowired
    private TransactionService xmlConversionService;

    @PostMapping(value = "/convertAndSave")
    public ResponseEntity<String> convertAndSaveTransaction(@RequestBody String xmlData) {
        Transaction transaction = xmlConversionService.convertXMLToJavaObject(xmlData);
        if (transaction != null) {
              Transaction stringResponse=  xmlConversionService.convertXMLToJavaObject(xmlData);
            Transaction savedTransaction = xmlConversionService.saveTransaction(transaction);
            return new ResponseEntity<>(stringResponse.toString(), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


}
