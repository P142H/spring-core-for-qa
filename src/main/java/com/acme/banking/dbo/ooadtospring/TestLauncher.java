package com.acme.banking.dbo.ooadtospring;

import com.acme.banking.dbo.ooadtospring.dao.StubAccountRepository;
import com.acme.banking.dbo.ooadtospring.service.ReportingService;

public class TestLauncher {
    public static void main(String[] args) {
        //Building
        ReportingService reportingService = new ReportingService(
                new StubAccountRepository(1.0)
        );

        System.out.println(reportingService.accountReport(1L));
    }
}
