package com.example.springbank.controller;


import com.example.springbank.domain.Account;
import com.example.springbank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping("/makeaccount")
    public ResponseEntity<String> makeAccount(Account acc) {
        ResponseEntity<String> res  = null;
        System.out.println(acc);
        try {
            accountService.makeAccount(acc);
            res = new ResponseEntity<String>("sucess",HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();;
            res= new ResponseEntity<String>("error", HttpStatus.BAD_GATEWAY);
        }
        return res;
    }
    @PostMapping("/accinfo")
    public  ResponseEntity<Account> accinfo(@RequestParam("id") String id){
        ResponseEntity<Account> res = null;
        System.out.println("id:" +id);
        try{
            Account acc = accountService.accountInfo(id);
            res = new ResponseEntity<Account>(acc, HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            res= new ResponseEntity<Account>(new Account(), HttpStatus.BAD_REQUEST);
        }
        return  res;
    }
    @PostMapping("/doubleid")
    public  ResponseEntity<String> doubldId(@RequestParam("id") String id){
        ResponseEntity<String> res = null;
        try{

        }
    }
}