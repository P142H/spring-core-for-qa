package com.acme.banking.dbo.ooadtospring.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("C")
public class CheckingAccount extends Account {
    private double overdraft;

    public CheckingAccount() {
    }

    public CheckingAccount(double amount, String email, double overdraft) {
        super(amount, email);
        this.overdraft = overdraft;
    }

    public String toString () {
        return super.toString() + " C " + overdraft;
    }
}
