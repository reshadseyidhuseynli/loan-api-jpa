package com.company.loanapijpa.service;

import com.company.loanapijpa.dto.request.PassportRequest;
import com.company.loanapijpa.dto.request.PersonalInformation;
import com.company.loanapijpa.entity.Customer;
import com.company.loanapijpa.mapper.CustomerMapper;
import com.company.loanapijpa.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final ContactService contactService;
    private final AddressService addressService;

    public Integer create(PassportRequest passportRequest) {
        Customer customer = customerMapper.toCustomer(passportRequest);
        return customerRepository.save(customer).getId();
    }

    public void addPersonalInformationToCustomer(Integer customerId,
                                                 PersonalInformation personalInformation) {
        int contactId = contactService.create(personalInformation.getContactRequest());
        int addressId = addressService.create(personalInformation.getAddressRequest());

        customerRepository.addContactAndAddressToCustomer(contactId, addressId, customerId);
    }

}
