package com.company.loanapijpa.service;

import com.company.loanapijpa.dto.request.ProductRequest;
import com.company.loanapijpa.entity.Loan;
import com.company.loanapijpa.error.exception.NotFoundException;
import com.company.loanapijpa.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService {

    private static final Double PRE_AMOUNT_PERCENT = 30.0;

    private final LoanRepository loanRepository;
    private final ProductService productService;

    public int create(Integer customerId, BigDecimal interestRate) {
        return loanRepository.createLoanForCustomer(customerId, interestRate);
    }

    public void addProductsToLoan(Integer loanId, List<ProductRequest> productRequests) {
        BigDecimal totalAmount = productService
                .createProducts(loanId, productRequests);
        BigDecimal preAmount = totalAmount
                .multiply(BigDecimal.valueOf(PRE_AMOUNT_PERCENT / 100));

        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found with given id: " + loanId));
        loan.setTotalAmount(totalAmount);
        loan.setPreAmount(preAmount);

        loanRepository.save(loan);
    }

}
