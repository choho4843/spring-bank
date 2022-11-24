package com.example.springbank.controller;


import com.example.springbank.domain.Account;
import com.example.springbank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.server.ExportException;
import java.util.List;

@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping("/makeaccount")
    public ResponseEntity<String> makeAccount(Account acc) {
        ResponseEntity<String> res = null;
        System.out.println(acc);
        try {
            accountService.makeAccount(acc);
            res = new ResponseEntity<String>("sucess", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            ;
            res = new ResponseEntity<String>("error", HttpStatus.BAD_GATEWAY);
        }
        return res;
    }

    @PostMapping("/accinfo")
    public ResponseEntity<Account> accinfo(@RequestParam("id") String id) {
        ResponseEntity<Account> res = null;
        System.out.println("id:" + id);
        try {
            Account acc = accountService.accountInfo(id);
            res = new ResponseEntity<Account>(acc, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            res = new ResponseEntity<Account>(new Account(), HttpStatus.BAD_REQUEST);
        }
        return res;
    }

    @PostMapping("/doubleid")
    public ResponseEntity<Boolean> doubledId(@RequestParam("id") String id) {
        ResponseEntity<Boolean> res = null;
        try {
            Boolean isdouble = accountService.checkDoubleId(id);
            res = new ResponseEntity<Boolean>(isdouble, HttpStatus.OK);
        } catch (Exception e) {
            res = new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
        }
        return res;
    }

    @PostMapping("/deposit")
    public ResponseEntity<Integer> deposit(@RequestParam("id") String id,
                                           @RequestParam("money") Integer money) {
        ResponseEntity<Integer> res = null;
        try {
            Integer balance = accountService.deposit(id, money);
            System.out.println(balance);
            res = new ResponseEntity<Integer>(balance, HttpStatus.OK);
        } catch (Exception e) {
            res = new ResponseEntity<Integer>(-1, HttpStatus.BAD_REQUEST);
        }
        return res;
    }

    @PostMapping("/withdraw")
    public ResponseEntity<Integer> Withdraw(@RequestParam("id") String id,
                                            @RequestParam("money") Integer money) {
        ResponseEntity<Integer> res = null;
        try {
            Integer balance = accountService.withdraw(id, money);
            System.out.println(id);
            res = new ResponseEntity<Integer>(balance, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            res = new ResponseEntity<Integer>(-1, HttpStatus.BAD_REQUEST);
        }
        return res;
    }

    @PostMapping("/transfor")
    public ResponseEntity<Integer> Withdraw(@RequestParam("sid") String sid, @RequestParam("rid") String rid,
                                            @RequestParam("money") Integer money) {
        ResponseEntity<Integer> res = null;
        try {
            Integer balance = accountService.transfor(sid, rid, money);
            res = new ResponseEntity<Integer>(balance, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            res = new ResponseEntity<Integer>(-1, HttpStatus.BAD_REQUEST);
        }
        return res;
    }
    @GetMapping("/all")
    public  ResponseEntity<List<Account>> allAccount(){
        ResponseEntity<List<Account>> res =null;
        List<Account> accs = null;
        try {
            accs=accountService.allAccount();
            res=new ResponseEntity<List<Account>>(accs, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            res=new ResponseEntity<List<Account>>(accs, HttpStatus.BAD_REQUEST);
        }
        return  res;
    }

}