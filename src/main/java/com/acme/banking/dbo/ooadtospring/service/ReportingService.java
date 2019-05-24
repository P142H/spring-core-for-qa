package com.acme.banking.dbo.ooadtospring.service;

import com.acme.banking.dbo.ooadtospring.dao.AccountRepository;
import com.acme.banking.dbo.ooadtospring.domain.Account;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
@PropertySource("classpath:application.properties")
public class ReportingService {
    @Autowired private Logger logger;

    @Value("${marker}") private String layoutMarker;
    @Autowired private AccountRepository accounts;

    public void setLayoutMarker(String layoutMarker) {
        this.layoutMarker = layoutMarker;
    }

    @Autowired public ReportingService(AccountRepository accounts) {
        this.accounts = accounts;
    }

    @PostConstruct
    public void onCreate() {
        logger.info("ReportingService created");
    }

    @PreDestroy
    public void onShutDown() {
        logger.info("ReportingService shut down");
    }

    public String accountReport(long id) {
        Account account = accounts.findById(id).orElseThrow(() -> new IllegalStateException("Account not found"));
        return layoutMarker + layoutMarker + " " + account.toString();
    }
}
