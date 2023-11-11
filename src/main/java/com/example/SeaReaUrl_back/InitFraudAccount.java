package com.example.SeaReaUrl_back;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitFraudAccount {

    private final InitFraudAccountService initFraudAccountService;

    @PostConstruct
    public void init() {
        initFraudAccountService.init();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitFraudAccountService {

        private final EntityManager em;

        public void init() {
            FraudAccount fraudAccount1 = createFraudAccount("https://www.instagram.com/newjeans_official/", false, 0L,0L);
            FraudAccount fraudAccount2 = createFraudAccount("NewJeans_twt", false, 0L,0L);
            FraudAccount fraudAccount3 = createFraudAccount("https://www.facebook.com/official.newjeans/", false, 0L,0L);
            FraudAccount fraudAccount4 = createFraudAccount("https://www.instagram.com/jennierubyjane/", false, 0L,0L);
            FraudAccount fraudAccount5 = createFraudAccount("https://www.instagram.com/thv/", false, 0L,0L);
            FraudAccount fraudAccount6 = createFraudAccount("elonmusk", false, 0L,0L);
            FraudAccount fraudAccount7 = createFraudAccount("https://www.instagram.com/hm_son7/", false, 0L,0L);
            FraudAccount fraudAccount8 = createFraudAccount("https://www.facebook.com/HeungMinSonOfficial/", false, 0L,0L);
            FraudAccount fraudAccount9 = createFraudAccount("https://www.instagram.com/paikscuisine_official/", false, 0L,0L);
            FraudAccount fraudAccount10 = createFraudAccount("https://www.instagram.com/gamst17172/", false, 0L,0L);
            FraudAccount fraudAccount11 = createFraudAccount("https://www.instagram.com/hhh_07/", false, 0L,0L);

            em.persist(fraudAccount1);
            em.persist(fraudAccount2);
            em.persist(fraudAccount3);
            em.persist(fraudAccount4);
            em.persist(fraudAccount5);
            em.persist(fraudAccount6);
            em.persist(fraudAccount7);
            em.persist(fraudAccount8);
            em.persist(fraudAccount9);
            em.persist(fraudAccount10);
            em.persist(fraudAccount11);



        }
        private FraudAccount createFraudAccount(String accountName, Boolean isFraud, Long view, Long report) {
            return new FraudAccount(accountName, isFraud, view, report);
        }

    }


}