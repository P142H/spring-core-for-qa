package com.acme.banking.dbo.ooadtospring.service;

import com.acme.banking.dbo.ooadtospring.dao.AccountRepository;
import com.acme.banking.dbo.ooadtospring.domain.Account;
import org.springframework.stereotype.Service;

@Service
public class TransferService {
    private AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void transfer(long fromId, long toId, double amount) {
        Account from = accountRepository.findById(fromId).orElseThrow(() -> new IllegalStateException("Account not found"));
        Account to = accountRepository.findById(toId).orElseThrow(() -> new IllegalStateException("Account not found"));

        from.setAmount(from.getAmount() - amount);
        to.setAmount(to.getAmount() + amount);

        accountRepository.save(from);
        accountRepository.save(to);
    }
}
