package com.e451.service;

import com.e451.domain.Transaction;
import com.e451.models.TransactionRecord;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;

/**
 * Created by e978726 on 2/27/2017.
 */
public interface TransactionService {
    Page<Transaction> getTransactions(org.springframework.data.domain.Pageable pageable);
    Converter<TransactionRecord, Transaction> getTransactionRecordTransactionConverter();
}
