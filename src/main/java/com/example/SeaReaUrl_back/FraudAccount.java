package com.example.SeaReaUrl_back;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class FraudAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    private String accountName;

    private Boolean IsFraud;

    private Long view;

    private Long report;

    public FraudAccount(String accountName, Boolean isFraud, Long view, Long report) {
        this.accountName = accountName;
        this.IsFraud = isFraud;
        this.view = view;
        this.report = report;

    }
}
