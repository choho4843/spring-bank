package com.example.springbank;

import com.example.springbank.domain.Account;
import com.example.springbank.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBankApplicationTests {

	@Autowired
	AccountRepository accountRepository;
	@Test
	void addAccount() {
		accountRepository.save(new Account("1234", "hong", "1234","VIP", 0));
	}

}
