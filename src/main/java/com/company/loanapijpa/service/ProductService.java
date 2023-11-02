package com.company.loanapijpa.service;

import com.company.loanapijpa.dto.request.ProductRequest;
import com.company.loanapijpa.entity.Product;
import com.company.loanapijpa.mapper.ProductMapper;
import com.company.loanapijpa.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public BigDecimal createProducts(Integer loanId, List<ProductRequest> productRequests) {
        return productRequests
                .stream()
                .map(productRequest -> {
                            Product product = productMapper.toProduct(productRequest);
                            productRepository.createProductForLoan(
                                    product.getName(),
                                    product.getPrice(),
                                    loanId
                            );

                            return product.getPrice();
                        }
                )
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
