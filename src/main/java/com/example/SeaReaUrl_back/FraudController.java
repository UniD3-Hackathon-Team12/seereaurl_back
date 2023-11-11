package com.example.SeaReaUrl_back;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/fraud")
public class FraudController {
    private final FraudService fraudService;

    @GetMapping("/account/view")
    public Top5Response getTop5AccountView(){
        return fraudService.getTop5AccountView();
//        return fraudService.getTop5AccountView();
    }
    @GetMapping("/url/view")
    public Top5Response getTop5UrlView(){
        return fraudService.getTop5UrlView();
    }
    @GetMapping("/account/report")
    public Top5Response getTop5AccountReports(){
        return fraudService.getTop5AccountReports();
    }
//    @GetMapping("/url/report")
//    public Top5Response getTop5UrlReports(){
//        return fraudService.getTop5UrlReports();
//    }
//
//    @PostMapping("/report/account")
//    public StringResponse reportAccount(){
//        return fraudService.reportAccount();
//    }
//    @PostMapping("/report/url")
//    public StringResponse reportUrl(){
//        return fraudService.reportUrl();
//    }
//
//    @GetMapping("/checkUrl")
//    public IsFraudUrlResponse checkUrlValidation(@RequestParam String url){
//        return fraudService.checkUrlValidation(url);
//    }
//
//    @GetMapping("/checkAccount")
//    public IsFraudAccountResponse checkAccountValidation(@RequestParam String accountName){
//        return fraudService.checkAccountValidation(accountName);
//    }





}
