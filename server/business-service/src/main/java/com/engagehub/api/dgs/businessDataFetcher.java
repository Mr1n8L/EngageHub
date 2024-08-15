package com.engagehub.api.dgs;

import com.engagehub.crm.business.model.Business;
import com.engagehub.crm.business.repository.BusinessRepository;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;

import java.util.List;

@DgsComponent
class BusinessDataFetcher {

    public final BusinessRepository businessRepository;

    public BusinessDataFetcher(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    @DgsQuery
    public List<Business> businesses() {
        return businessRepository.findAll();
    }

    @DgsQuery
    public Business business(Long id) {
        return businessRepository.findById(id).orElse(null);
    }
}
