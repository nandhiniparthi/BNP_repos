package com.bank.service;

import java.security.Principal;

import com.bank.model.PrimaryAccount;
import com.bank.model.SavingsAccount;



public interface AccountService {

	PrimaryAccount createPrimaryAccount();
    SavingsAccount createSavingsAccount();
    void deposit(String accountType, double amount, Principal principal);
    void withdraw(String accountType, double amount, Principal principal);
}
