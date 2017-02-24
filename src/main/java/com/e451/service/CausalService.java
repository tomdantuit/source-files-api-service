package com.e451.service;


import org.springframework.data.domain.Page;
import com.e451.domain.Causal;

public interface CausalService {

    Page<Causal> getCausals(org.springframework.data.domain.Pageable pageable);
}
