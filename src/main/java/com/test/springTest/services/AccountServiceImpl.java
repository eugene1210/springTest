package com.test.springTest.services;

import com.test.springTest.entity.Account;
import com.test.springTest.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Long createAccount(Long id, String nameRu, String nameKz, Long stateId) {
        Account account = new Account(id, nameRu, nameKz, stateId);
        return accountRepository.save(account).getId();
    }
}
