package com.e451.service;

import com.e451.domain.Transaction;
import com.e451.models.TransactionRecord;
import com.e451.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by e978726 on 2/27/2017.
 */

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    // Converter used to map a db entity to a domain object
    private static final Converter<TransactionRecord, Transaction > transactionRecordTransactionConverter
            = new Converter<TransactionRecord, Transaction>() {

        @Override
        public Transaction convert(TransactionRecord transactionRecord) {

            return new Transaction(transactionRecord.getHouseholdKey(),
                    transactionRecord.getBasketId(),
                    transactionRecord.getDay(),
                    transactionRecord.getProductId(),
                    transactionRecord.getQuantity(),
                    transactionRecord.getSalesValue(),
                    transactionRecord.getStoreId(),
                    transactionRecord.getCouponMatchDiscount(),
                    transactionRecord.getCouponDisc(),
                    transactionRecord.getRetailDisc(),
                    transactionRecord.getTransTime(),
                    transactionRecord.getWeekNo());

        }
    };


    public Converter<TransactionRecord, Transaction> getTransactionRecordTransactionConverter() {
        return transactionRecordTransactionConverter;
    }

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Page<Transaction> getTransactions(Pageable pageable) {

        Page<TransactionRecord> result = transactionRepository.findAll(pageable);

        return result.map(transactionRecordTransactionConverter);
    }
}
