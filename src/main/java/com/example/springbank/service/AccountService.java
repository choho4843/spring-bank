package com.example.springbank.service;

import com.example.springbank.domain.Account;
import com.example.springbank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public  void makeAccount(Account acc) throws  Exception{
        acc.setBalance(0);
        accountRepository.save(acc);
    }
    public  Account accountInfo(String id) throws Exception {
        Optional<Account> oacc = accountRepository.findById(id);
        if(!oacc.isPresent()) throw new Exception("계좌번호 오류");
        return oacc.get();
    }
    public String checkDoubleId(String id) throws Exception{
        Optional<Account> oacc = accountRepository.findById(id);
        if(oacc.isPresent()) return "true";
        return  "false";
    }
}
