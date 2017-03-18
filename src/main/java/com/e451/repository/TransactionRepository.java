package com.e451.repository;

import com.e451.model.TransactionRecord;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends PagingAndSortingRepository<TransactionRecord, Long> {
}
