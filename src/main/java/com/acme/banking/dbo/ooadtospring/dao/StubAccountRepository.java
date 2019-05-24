package com.acme.banking.dbo.ooadtospring.dao;

import com.acme.banking.dbo.ooadtospring.domain.Account;
import com.acme.banking.dbo.ooadtospring.domain.SavingAccount;

public class StubAccountRepository implements AccountRepository {
    private double amount;

    public StubAccountRepository(double amount) {
        this.amount = amount;
    }

    @Override
    public Account findById(long id) {
        return new SavingAccount(0, amount);
    }
}
