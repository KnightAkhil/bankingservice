package com.capgemini.genz.vertexai.bankingservice.service;

import com.capgemini.genz.vertexai.bankingservice.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AccountServiceTests {

    @Autowired
    private AccountServiceImpl accountService;

    @BeforeEach
    public void setUp() {
        accountService = new AccountServiceImpl();
    }

    @Test
    public void testCreateAndRetrieveAccount() {
        Account account = new Account();
        account.setId(1L);
        account.setAccountNumber("12345");
        account.setBalance(1000.0);
        account.setOwnerName("John Doe");
        account.setAccountType("Checking");

        accountService.createAccount(account);
        Account retrievedAccount = accountService.getAccountById(1L);

        assertNotNull(retrievedAccount);
        assertEquals("12345", retrievedAccount.getAccountNumber());
    }

    @Test
    public void testUpdateAccount() {
        Account account = new Account();
        account.setId(2L);
        account.setAccountNumber("54321");
        account.setBalance(2000.0);
        account.setOwnerName("Jane Doe");
        account.setAccountType("Savings");

        accountService.createAccount(account);
        account.setBalance(3000.0);
        accountService.updateAccount(account);

        Account updatedAccount = accountService.getAccountById(2L);
        assertNotNull(updatedAccount);
        assertEquals(3000.0, updatedAccount.getBalance());
    }

}
