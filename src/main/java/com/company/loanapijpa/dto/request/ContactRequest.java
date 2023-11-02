package com.company.loanapijpa.dto.request;

import lombok.Data;

@Data
public class ContactRequest {

    private String homeNumber;
    private String workNumber;
    private String mobileNumber;
    private String email;

}
