package com.example.SeaReaUrl_back;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
public class Top5Response {

    private List<Top5AccountResponse> top5Accounts;

    public Top5Response(List<Top5AccountResponse> top5Accounts) {
        this.top5Accounts = top5Accounts;
    }

//    private List<FraudAccount> top5Accounts;
//
//    public Top5Response(List<FraudAccount> top5Accounts) {
//        this.top5Accounts = top5Accounts;
//    }
//
//    public List<FraudAccount> getTop5Accounts() {
//        return top5Accounts;
//    }
//    private Long id;
//    private String url;
//    private Boolean IsFraud;
//    private Long view;
//    private Long report;
//
//    public static Top5Response {
//        return Top5Response.builder()
//                .id()
//                .build();
//    }

}
