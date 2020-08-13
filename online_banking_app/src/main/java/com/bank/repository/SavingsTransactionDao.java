package com.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.model.SavingsTransaction;

public interface SavingsTransactionDao  extends JpaRepository<SavingsTransaction, Long>{

	List<SavingsTransaction> findAll();
}
