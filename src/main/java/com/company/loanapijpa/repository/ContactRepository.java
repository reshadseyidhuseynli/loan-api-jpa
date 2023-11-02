package com.company.loanapijpa.repository;

import com.company.loanapijpa.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
