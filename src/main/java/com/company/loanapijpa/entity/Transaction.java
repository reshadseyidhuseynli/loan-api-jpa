package com.company.loanapijpa.entity;

import com.company.loanapijpa.enamuration.ActionStatus;
import com.company.loanapijpa.enamuration.FinalStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "transaction")
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "action_status")
    @Enumerated(EnumType.STRING)
    private ActionStatus actionStatus;
    @Column(name = "reject_reason")
    private String rejectReason;
    @Column(name = "final_status")
    @Enumerated(EnumType.STRING)
    private FinalStatus finalStatus;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

}
