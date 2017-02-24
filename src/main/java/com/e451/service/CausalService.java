package com.e451.service;


import com.e451.models.CausalRecord;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import com.e451.domain.Causal;

public interface CausalService {

    Page<Causal> getCausals(org.springframework.data.domain.Pageable pageable);
    Converter<CausalRecord, Causal> getCausalRecordCausalConverter();
}
