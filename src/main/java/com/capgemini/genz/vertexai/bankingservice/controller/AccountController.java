package com.capgemini.genz.vertexai.bankingservice.controller;

import com.capgemini.genz.vertexai.bankingservice.model.Account;
import com.capgemini.genz.vertexai.bankingservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vertextai/v1")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/createAccount")
    public ResponseEntity<String> createAccount(@RequestBody Account account) {
        accountService.createAccount(account);
        return ResponseEntity.ok("Account created");
    }

    @GetMapping("/getAccountById/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable Long id) {
        Account account = accountService.getAccountById(id);
        if (account != null) {
            return ResponseEntity.ok(account);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateAccount")
    public ResponseEntity<String> updateAccount(@RequestBody Account account) {
        accountService.updateAccount(account);
        return ResponseEntity.ok("Account updated");
    }

    @DeleteMapping("/deleteAccountById/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account deleted");
    }

    @GetMapping("/getAllAccounts")
    public ResponseEntity<List<Account>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

}
