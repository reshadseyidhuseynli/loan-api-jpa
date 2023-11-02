package com.company.loanapijpa.mapper;

import com.company.loanapijpa.dto.request.AddressRequest;
import com.company.loanapijpa.entity.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address toAddress(AddressRequest addressRequest);

}
