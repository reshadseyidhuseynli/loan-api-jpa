package com.company.loanapijpa.service;

import com.company.loanapijpa.dto.request.ContactRequest;
import com.company.loanapijpa.entity.Contact;
import com.company.loanapijpa.mapper.ContactMapper;
import com.company.loanapijpa.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    public int create(ContactRequest contactRequest) {
        Contact contact = contactMapper.toContact(contactRequest);
        return contactRepository.save(contact).getId();
    }

}
