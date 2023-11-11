package com.example.SeaReaUrl_back;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Top5AccountResponse {
    private Long id;
    private String url;
    private Boolean isFraud;
    private Long view;
    private Long report;

    public Top5AccountResponse(FraudAccount account) {
        this.id = account.getId();
        this.url = account.getAccountName();
        this.isFraud = account.getIsFraud();
        this.view = account.getView();
        this.report = account.getReport();
    }
}
