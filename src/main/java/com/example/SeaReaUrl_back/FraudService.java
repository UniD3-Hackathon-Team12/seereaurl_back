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

    private final FraudUrlRepository fraudUrlRepository;
    private final FraudAccountRepository fraudAccountRepository;

    @Transactional
    public List<Top5Response> getTop5AccountView() {
        List<Top5Response> dtos = new ArrayList<>();
        List<FraudAccount> top5Accounts = fraudAccountRepository.findTop5ByOrderByViewDesc();
        for (FraudAccount fraudAccount : top5Accounts){
            dtos.add(new Top5Response(fraudAccount.getAccountName()));
        }
        return dtos;
    }
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
