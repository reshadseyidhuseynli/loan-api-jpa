package com.company.loanapijpa.repository;

import com.company.loanapijpa.enamuration.ActionStatus;
import com.company.loanapijpa.enamuration.FinalStatus;
import com.company.loanapijpa.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Modifying
    @Query(value = "INSERT INTO transaction (action_status, final_status, customer_id) " +
            "VALUES(?1, ?2, ?3)", nativeQuery = true)
    void createTransactionForCustomer(ActionStatus actionStatus, FinalStatus finalStatus, Integer customerId);

}
