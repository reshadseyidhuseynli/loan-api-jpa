package com.company.loanapijpa.dto;

import com.company.loanapijpa.enamuration.ActionStatus;
import com.company.loanapijpa.enamuration.FinalStatus;
import lombok.Data;

@Data
public class TransactionDto {

    private Integer id;
    private ActionStatus actionStatus;
    private String rejectReason;
    private FinalStatus finalStatus;
    private Integer customerId;

}
