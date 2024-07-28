package com.capgemini.genz.vertexai.bankingservice.service;

import com.capgemini.genz.vertexai.bankingservice.model.Account;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{
    // A list to store accounts, simulating a database
    private List<Account> accounts = new ArrayList<>();

    @Override
    public void createAccount(Account account) {
        accounts.add(account);
    }

    @Override
    public Account getAccountById(Long id) {
        return accounts.stream()
                .filter(account -> account.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateAccount(Account account) {
        Account existingAccount = getAccountById(account.getId());
        if (existingAccount != null) {
            existingAccount.setAccountNumber(account.getAccountNumber());
            existingAccount.setBalance(account.getBalance());
            existingAccount.setOwnerName(account.getOwnerName());
            existingAccount.setAccountType(account.getAccountType());
        }
    }

    @Override
    public void deleteAccount(Long id) {
        accounts.removeIf(account -> account.getId().equals(id));
    }

    @Override
    public List<Account> getAllAccounts() {
        return accounts;
    }
}
