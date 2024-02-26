package com.example.Account_ann.repository;

import com.example.Account_ann.domain.Account;
import com.example.Account_ann.domain.AccountUser;
import com.example.Account_ann.domain.Transaction;
import com.example.Account_ann.dto.TransactionDto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {


}
