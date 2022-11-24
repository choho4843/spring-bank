package com.example.springbank.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Account {
    @Id
    private  String id;
    @Column
    private String name;
    @Column
    private  String password;
    @Column
    private  String grade;
    @Column
    private Integer balance;
    public void deposit(Integer money){
        this.balance +=money;
    }
    public  void withdraw(Integer money)throws Exception{
        if(this.balance < money) throw new Exception("잔액 부족");
        this.balance -= money;
    }
    public  void transfor(Integer money)throws Exception{
        if(this.balance < money) throw new Exception("잔액 부족");
        this.balance -= money;
    }
}
