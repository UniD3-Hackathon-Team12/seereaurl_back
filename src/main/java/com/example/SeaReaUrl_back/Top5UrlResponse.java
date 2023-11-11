package com.example.SeaReaUrl_back;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Top5UrlResponse {
    private Long id;
    private String url;
    private Boolean isFraud;
    private Long view;
    private Long report;

    public Top5UrlResponse(FraudUrl url) {
        this.id = url.getId();
        this.url = url.getUrl();
        this.isFraud = url.getIsFraud();
        this.view = url.getView();
        this.report = url.getReport();
    }
}
