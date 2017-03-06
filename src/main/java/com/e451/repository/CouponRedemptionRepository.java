package com.e451.repository;


import com.e451.model.CouponRedemptionRecord;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRedemptionRepository extends PagingAndSortingRepository<CouponRedemptionRecord, Long> {
}
