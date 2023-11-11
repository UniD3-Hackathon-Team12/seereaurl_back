package com.example.SeaReaUrl_back;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class FraudService {
    private final FraudAccountRepository fraudAccountRepository;
    private final FraudUrlRepository fraudUrlRepository;

    @Transactional
    public Top5Response getTop5AccountView() {
        List<FraudAccount> top5Accounts = fraudAccountRepository.findTop5ByOrderByViewDesc();
        List<Top5AccountResponse> top5AccountResponses = top5Accounts.stream()
                .map(Top5AccountResponse::new)
                .collect(Collectors.toList());
        return new Top5Response(top5AccountResponses);
    }

//    private Top5Response convertToTop5Response(List<FraudAccount> top5Accounts) {
//        List<Top5Response> responses = top5Accounts.stream()
//                .map(account -> new Top5Response(account.getId(), account.getUrl(), account.getIsFraud(), account.getView(), account.getReport()))
//                .collect(Collectors.toList());
//
//        // 상위 5개의 계정을 담은 단일 Top5Response를 반환하려면
//        return new Top5Response(responses);
//    }

//    @Transactional
//    public Top5Response getTop5AccountView(){
//        return new Top5Response();
//    }
//    @Transactional
//    public Top5Response getTop5UrlView(){
//        return new Top5Response();
//    }
//    @Transactional
//    public Top5Response getTop5AccountReports(){
//        return new Top5Response();
//    }
//    @Transactional
//    public Top5Response getTop5UrlReports(){
//        return new Top5Response();
//    }
//
//    @Transactional
//    public StringResponse reportAccount(){
//        return new StringResponse();
//    }
//    @Transactional
//    public StringResponse reportUrl(){
//        return new StringResponse();
//    }
//
//    @Transactional
//    public IsFraudUrlResponse checkUrlValidation(String url){
//        List<String> responseList = new ArrayList<>();
//        return new IsFraudUrlResponse(responseList);
//    }
//    @Transactional
//    public IsFraudAccountResponse checkAccountValidation(String accountName){
//        return new IsFraudAccountResponse(accountName);
//    }
}
