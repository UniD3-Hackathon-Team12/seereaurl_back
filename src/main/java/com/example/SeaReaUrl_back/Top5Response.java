package com.example.SeaReaUrl_back;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Top5Response {

    private List<Top5AccountResponse> top5Accounts;
    private List<Top5UrlResponse> top5Urls;

    public Top5Response(List<Top5AccountResponse> top5Accounts, List<Top5UrlResponse> top5Urls) {
        this.top5Accounts = top5Accounts;
        this.top5Urls = top5Urls;
    }

//    public Top5Response(List<Top5UrlResponse> top5Urls) {
//        this.top5Urls = top5Urls;
//    }

}
