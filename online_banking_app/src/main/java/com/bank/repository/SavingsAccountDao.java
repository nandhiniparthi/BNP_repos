package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.model.SavingsAccount;

public interface SavingsAccountDao extends JpaRepository<SavingsAccount, Long>{

	 SavingsAccount findByAccountNumber (int accountNumber);

}
