package com.e451.service;


import com.e451.domain.Causal;
import org.springframework.cache.interceptor.CacheAspectSupport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CausalServiceImpl implements CausalService {

    @Override
    public Page<Causal> getCausals(Pageable pageable) {

        List<Causal> causals = new ArrayList<>(1);

        causals.add(new Causal(new Long(1)
            , new Long(2)
            , 3
            , "display"
            , "mailer"));

        Page<Causal> result = new PageImpl<Causal>(causals);
        return result;
    }
}
