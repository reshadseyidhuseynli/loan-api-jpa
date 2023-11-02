package com.company.loanapijpa.service;

import com.company.loanapijpa.dto.TransactionDto;
import com.company.loanapijpa.enamuration.ActionStatus;
import com.company.loanapijpa.enamuration.FinalStatus;
import com.company.loanapijpa.entity.Transaction;
import com.company.loanapijpa.error.exception.NotFoundException;
import com.company.loanapijpa.mapper.TransactionMapper;
import com.company.loanapijpa.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    public void create(Integer customerId) {
        transactionRepository.createTransactionForCustomer(
                ActionStatus.WAITING_FOR_IDENTITY_APPROVE,
                FinalStatus.IN_PROGRESS,
                customerId
        );
    }

    public TransactionDto getById(Integer id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Transaction not found with given id: " + id));
        return transactionMapper.toTransactionDto(transaction);
    }

    public void update(TransactionDto transactionDto) {
        Transaction transaction = transactionMapper.toTransaction(transactionDto);
        transactionRepository.save(transaction);
    }

}
