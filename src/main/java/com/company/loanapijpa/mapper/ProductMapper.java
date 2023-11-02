package com.company.loanapijpa.mapper;

import com.company.loanapijpa.dto.request.ProductRequest;
import com.company.loanapijpa.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toProduct(ProductRequest productRequest);

}
