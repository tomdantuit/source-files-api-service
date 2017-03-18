package com.e451.service;

import com.e451.domain.Transaction;
import com.e451.model.TransactionRecord;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;

public interface TransactionService {
    Page<Transaction> getTransactions(org.springframework.data.domain.Pageable pageable);
    Converter<TransactionRecord, Transaction> getTransactionRecordTransactionConverter();
}
