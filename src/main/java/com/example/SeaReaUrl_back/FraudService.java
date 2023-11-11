package com.example.SeaReaUrl_back;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class FraudService {
    private final FraudAccountRepository fraudAccountRepository;
    private final FraudUrlRepository fraudUrlRepository;


//    @Transactional
//    public List<Top5AccountResponse> getTop5AccountView() {
//        List<FraudAccount> top5Accounts = fraudAccountRepository.findTop5ByOrderByViewDesc();
//        return top5Accounts.stream()
//                .map(Top5AccountResponse::new)
//                .collect(Collectors.toList());
//    }
    @Transactional
    public Top5Response getTop5AccountView() {
        // FraudAccount 테이블에서 조회
        List<FraudAccount> top5Accounts = fraudAccountRepository.findTop5ByOrderByViewDesc();
        List<Top5AccountResponse> top5AccountResponses = top5Accounts.stream()
                .map(Top5AccountResponse::new)
                .collect(Collectors.toList());

        // 빈 리스트로 초기화된 Top5UrlResponse 리스트 생성
        List<Top5UrlResponse> top5UrlResponses = new ArrayList<>();

        // 응답 객체에 결과를 담아 반환
        return new Top5Response(top5AccountResponses, top5UrlResponses);
    }

    @Transactional
    public Top5Response getTop5UrlView() {
        // 빈 리스트로 초기화된 Top5AccountResponse 리스트 생성
        List<Top5AccountResponse> top5AccountResponses = new ArrayList<>();

        // FraudUrl 테이블에서 조회
        List<FraudUrl> top5Urls = fraudUrlRepository.findTop5ByOrderByViewDesc();
        List<Top5UrlResponse> top5UrlResponses = top5Urls.stream()
                .map(Top5UrlResponse::new)
                .collect(Collectors.toList());

        // 응답 객체에 결과를 담아 반환
        return new Top5Response(top5AccountResponses, top5UrlResponses);
    }


//    @Transactional
//    public Top5Response getTop5AccountAndView() {
//        List<FraudAccount> top5Accounts = fraudAccountRepository.findTop5ByOrderByViewDesc();
//        List<Top5AccountResponse> top5AccountResponses = top5Accounts.stream()
//                .map(Top5AccountResponse::new)
//                .collect(Collectors.toList());
//
//        List<FraudUrl> top5Urls = fraudUrlRepository.findTop5ByOrderByViewDesc();
//        List<Top5UrlResponse> top5UrlResponses = top5Urls.stream()
//                .map(Top5UrlResponse::new)
//                .collect(Collectors.toList());
//
//        return new Top5Response(top5AccountResponses, top5UrlResponses);
//    }


    @Transactional
    public Top5Response getTop5AccountReports(){
        // FraudAccount 테이블에서 조회
        List<FraudAccount> top5Accounts = fraudAccountRepository.findTop5ByOrderByReportDesc();
        List<Top5AccountResponse> top5AccountResponses = top5Accounts.stream()
                .map(Top5AccountResponse::new)
                .collect(Collectors.toList());

        // 빈 리스트로 초기화된 Top5UrlResponse 리스트 생성
        List<Top5UrlResponse> top5UrlResponses = new ArrayList<>();

        // 응답 객체에 결과를 담아 반환
        return new Top5Response(top5AccountResponses, top5UrlResponses);
    }
    @Transactional
    public Top5Response getTop5UrlReports(){
        // 빈 리스트로 초기화된 Top5AccountResponse 리스트 생성
        List<Top5AccountResponse> top5AccountResponses = new ArrayList<>();

        // FraudUrl 테이블에서 조회
        List<FraudUrl> top5Urls = fraudUrlRepository.findTop5ByOrderByReportDesc();
        List<Top5UrlResponse> top5UrlResponses = top5Urls.stream()
                .map(Top5UrlResponse::new)
                .collect(Collectors.toList());

        // 응답 객체에 결과를 담아 반환
        return new Top5Response(top5AccountResponses, top5UrlResponses);
    }
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
    private RestTemplate restTemplate = new RestTemplate();

    public IsFraudUrlResponse checkUrlValidation(String url){
        String pythonServerUrl = "http://localhost:5000/fraud";

        Map<String, String> params = new HashMap<>();
        params.put("url", url);

        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(params);
        ResponseEntity<String> responseEntity = restTemplate.exchange(pythonServerUrl, HttpMethod.POST, requestEntity, String.class);

        String result = responseEntity.getBody();
//        double percentage = Double.parseDouble(result.split("%")[0]);

        IsFraudUrlResponse isFraudUrlResponse = new IsFraudUrlResponse();
//        isFraudUrlResponse.setPercentage(percentage);
//        isFraudUrlResponse.setIsSafe(result.contains("safe"));
        isFraudUrlResponse.setFraudPossibility(result);

        return isFraudUrlResponse;
    }
//    @Transactional
//    public IsFraudAccountResponse checkAccountValidation(String accountName){
//        return new IsFraudAccountResponse(accountName);
//    }
}
