package com.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.model.PrimaryTransaction;

public interface PrimaryTransactionDao extends JpaRepository<PrimaryTransaction, Long> {

    List<PrimaryTransaction> findAll();
}
