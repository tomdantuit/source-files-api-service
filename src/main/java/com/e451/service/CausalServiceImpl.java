package com.e451.service;


import com.e451.domain.Causal;
import com.e451.model.CausalRecord;
import com.e451.repository.CausalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class CausalServiceImpl implements CausalService {

    CausalRepository causalRepository;

    @Autowired
    public CausalServiceImpl(CausalRepository causalRepository) {
        this.causalRepository = causalRepository;
    }

    // Converter used to map a db entity to a domain object
    private static final Converter<CausalRecord, Causal> CausalRecordCausalConverter
            = new Converter<CausalRecord, Causal>() {
        @Override
        public Causal convert(CausalRecord causalRecord) {

            return new Causal(causalRecord.getId()
                , causalRecord.getProduct_id()
                , causalRecord.getStore_id()
                , causalRecord.getWeek_no()
                , causalRecord.getDisplay()
                , causalRecord.getMailer());
        }
    };

    Converter<CausalRecord, Causal> getCausalRecordCausalConverter() {
        return CausalRecordCausalConverter;
    }


    @Override
    public Page<Causal> getCausals(Pageable pageable) {
        Page<CausalRecord> result = causalRepository.findAll(pageable);
        return result.map(CausalRecordCausalConverter);
    }
}
