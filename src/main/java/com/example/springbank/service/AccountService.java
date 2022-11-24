package com.example.springbank.service;

import com.example.springbank.domain.Account;
import com.example.springbank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public Boolean checkDoubleId(String id) throws Exception{
        Optional<Account> oacc = accountRepository.findById(id);
        if(oacc.isPresent()) return true;
        return false;
    }
    public Integer deposit(String id, Integer money) throws Exception {
        Optional<Account> oacc = accountRepository.findById(id);
        if(!oacc.isPresent()) throw  new Exception("계좌번호 오류");
        Account acc = oacc.get();
        acc.deposit(money);
        accountRepository.save(acc);
        return acc.getBalance();
    }
    public Integer withdraw(String id, Integer money) throws Exception {
        Optional<Account> oacc = accountRepository.findById(id);
        if(!oacc.isPresent()) throw  new Exception("계좌번호 오류");
        Account acc = oacc.get();
        acc.withdraw(money);
        accountRepository.save(acc);
        return acc.getBalance();
    }
    public  Integer transfor(String sid, String rid, Integer money) throws  Exception{
        Optional<Account> osacc = accountRepository.findById(sid);
        if(!osacc.isPresent()) throw  new Exception("전송계좌번호 오류");
        Account sacc = osacc.get();
        sacc.withdraw(money);
        Optional<Account> rsacc = accountRepository.findById(rid);
        if(!rsacc.isPresent()) throw  new Exception("전송계좌번호 오류");
        Account racc = rsacc.get();
        racc.deposit((money));
        accountRepository.save(sacc);
        accountRepository.save(racc);
        return sacc.getBalance();
    }
    public List<Account> allAccount() throws Exception{
        List<Account> accs = accountRepository.findAll();
        return  accs;
    }
}
