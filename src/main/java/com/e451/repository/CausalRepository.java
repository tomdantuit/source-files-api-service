package com.e451.repository;

import com.e451.models.CausalRecord;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CausalRepository extends PagingAndSortingRepository<CausalRecord, Long> {
}
