package com.e451.repository;

import com.e451.model.CouponRecord;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends PagingAndSortingRepository<CouponRecord, Long>{
}
