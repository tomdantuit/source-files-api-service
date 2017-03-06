package com.e451.repository;

import com.e451.models.TransactionRecord;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by e978726 on 2/26/2017.
 */

@Repository
public interface TransactionRepository extends PagingAndSortingRepository<TransactionRecord, Long> {
}
