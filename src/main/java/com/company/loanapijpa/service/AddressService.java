package com.company.loanapijpa.service;

import com.company.loanapijpa.dto.request.AddressRequest;
import com.company.loanapijpa.entity.Address;
import com.company.loanapijpa.mapper.AddressMapper;
import com.company.loanapijpa.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public int create(AddressRequest addressRequest) {
        Address address = addressMapper.toAddress(addressRequest);
        return addressRepository.save(address).getId();
    }

}
