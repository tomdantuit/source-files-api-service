package com.e451.service;

import com.e451.domain.DataModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DataModelService {
    Page<DataModel> getDataModels(Pageable pageable);
}
