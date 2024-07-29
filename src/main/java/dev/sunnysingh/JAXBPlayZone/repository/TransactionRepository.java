package dev.sunnysingh.JAXBPlayZone.repository;

import dev.sunnysingh.JAXBPlayZone.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}