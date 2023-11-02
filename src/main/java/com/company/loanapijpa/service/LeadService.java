package com.company.loanapijpa.service;

import com.company.loanapijpa.dto.TransactionDto;
import com.company.loanapijpa.enamuration.ActionStatus;
import com.company.loanapijpa.enamuration.FinalStatus;
import com.company.loanapijpa.enamuration.LeadReply;
import com.company.loanapijpa.error.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class LeadService {

    private final TransactionService transactionService;

    public void identifyStatus(Integer transactionId, LeadReply reply, String rejectReason) {
        checkRequest(reply, rejectReason);
        updateTransaction(
                transactionId,
                reply,
                rejectReason,
                ActionStatus.IDENTITY_CHECK_APPROVED,
                false);
    }

    public void initialStatus(Integer transactionId, LeadReply reply, String rejectReason) {
        checkRequest(reply, rejectReason);
        updateTransaction(
                transactionId,
                reply,
                rejectReason,
                ActionStatus.INITIAL_CHECK_APPROVED,
                false);
    }

    public void finalStatus(Integer transactionId, LeadReply reply, String rejectReason) {
        checkRequest(reply, rejectReason);
        updateTransaction(
                transactionId,
                reply,
                rejectReason,
                ActionStatus.FINAL_CHECK_APPROVED,
                true);
    }

    private void checkRequest(LeadReply reply, String rejectReason) {
        boolean rejectReasonIsEmpty = Objects.isNull(rejectReason) || rejectReason.trim().isEmpty();
        if (reply != LeadReply.APPROVE && rejectReasonIsEmpty) {
            throw new BadRequestException("Reject reason can not be empty");
        }
        if (reply == LeadReply.APPROVE && !rejectReasonIsEmpty) {
            throw new BadRequestException("Reject reason must be empty");
        }
    }

    private void updateTransaction(Integer transactionId,
                                   LeadReply reply,
                                   String rejectReason,
                                   ActionStatus nextStatus,
                                   boolean isFinal) {
        TransactionDto transaction = transactionService.getById(transactionId);
        if (reply == LeadReply.APPROVE) {
            transaction.setActionStatus(nextStatus);
            if (isFinal) {
                transaction.setFinalStatus(FinalStatus.COMPLETED);
            }
        } else {
            transaction.setRejectReason(rejectReason);
        }
        transactionService.update(transaction);
    }

}
