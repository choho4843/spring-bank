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

}
