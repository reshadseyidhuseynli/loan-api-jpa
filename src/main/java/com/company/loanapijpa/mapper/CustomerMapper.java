package com.company.loanapijpa.mapper;

import com.company.loanapijpa.dto.request.PassportRequest;
import com.company.loanapijpa.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toCustomer(PassportRequest passportRequest);

}
