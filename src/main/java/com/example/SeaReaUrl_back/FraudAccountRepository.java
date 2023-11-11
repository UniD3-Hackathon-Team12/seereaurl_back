package com.example.SeaReaUrl_back;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FraudAccountRepository extends JpaRepository<FraudAccount, Long> {
    List<FraudAccount> findTop5ByOrderByViewDesc();
    List<FraudAccount> findTop5ByOrderByReportDesc();
}
