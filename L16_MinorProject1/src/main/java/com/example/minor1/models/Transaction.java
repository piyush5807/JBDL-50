package com.example.minor1.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String txnId;

    @Enumerated(value = EnumType.STRING)
    private TransactionType transactionType;

    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

    @CreationTimestamp
    private Date createdOn; // t1

    @UpdateTimestamp
    private Date updatedOn; // t2

    private Integer fine;

    @JoinColumn
    @ManyToOne
    @JsonIgnoreProperties({"transactionList"})
    private Book book;

    @JoinColumn
    @ManyToOne
    @JsonIgnoreProperties({"transactionList"})
    private Student student;

    @JoinColumn
    @ManyToOne
    @JsonIgnoreProperties({"transactionList"})
    private Admin admin;
}
