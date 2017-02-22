package com.e451.service;

import com.e451.domain.DataModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataModelServiceImpl implements DataModelService {
    @Override
    public Page<DataModel> getDataModels(Pageable pageable) {
        List<DataModel> dataModels= new ArrayList<>(1);

        dataModels.add(new DataModel(new Long(1), "The Complete Journey"));

        Page<DataModel> result = new PageImpl<DataModel>(dataModels);
        return result;
    }
}
