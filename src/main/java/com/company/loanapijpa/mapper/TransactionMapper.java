package com.company.loanapijpa.mapper;

import com.company.loanapijpa.dto.TransactionDto;
import com.company.loanapijpa.entity.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    Transaction toTransaction(TransactionDto transactionDto);

    TransactionDto toTransactionDto(Transaction transaction);
}
