package com.example.SeaReaUrl_back;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FraudUrlRepository extends JpaRepository<FraudUrl, Long> {
    List<FraudUrl> findTop5ByOrderByViewDesc();
    List<FraudUrl> findTop5ByOrderByReportDesc();
}
