package com.company.loanapijpa.mapper;

import com.company.loanapijpa.dto.request.ContactRequest;
import com.company.loanapijpa.entity.Contact;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {

    Contact toContact(ContactRequest contactRequest);

}
