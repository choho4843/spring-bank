package com.example.springbank.service;

import com.example.springbank.domain.Account;
import com.example.springbank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public  void makeAccount(Account acc) throws  Exception{
        acc.setBalance(0);
        accountRepository.save(acc);
    }
}
