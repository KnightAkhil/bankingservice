package com.capgemini.genz.vertexai.bankingservice.service;

import com.capgemini.genz.vertexai.bankingservice.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {

    public void createAccount(Account account);
    public Account getAccountById(Long id);
    public void updateAccount(Account account);
    public void deleteAccount(Long id);
    public List<Account> getAllAccounts();
}
