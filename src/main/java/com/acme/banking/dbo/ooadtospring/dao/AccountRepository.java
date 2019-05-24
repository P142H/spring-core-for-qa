package com.acme.banking.dbo.ooadtospring.dao;

import com.acme.banking.dbo.ooadtospring.domain.Account;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("test")
public interface AccountRepository extends JpaRepository<Account, Long> {
}
