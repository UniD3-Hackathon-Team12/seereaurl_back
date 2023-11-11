package com.example.SeaReaUrl_back;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IsFraudUrlResponse {
//    private List<String> responseList;
    private String fraudPossibility;
}
