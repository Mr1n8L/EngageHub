package com.engagehub.api.dgs;

import com.engagehub.api.model.Business;
import com.engagehub.api.service.BusinessService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@DgsComponent
public class BusinessDataFetcher {

    private final BusinessService businessService;

    @Autowired
    public BusinessDataFetcher(BusinessService businessService) {
        this.businessService = businessService;
    }

    @DgsQuery
    public List<Business> businesses() {
        return businessService.getAllBusinesses();
    }

    @DgsQuery
    public Optional<Business> business(@InputArgument Long id) {
        return businessService.getBusinessById(id);
    }

    @DgsMutation
    public Business addBusiness(@InputArgument String name, @InputArgument String address, @InputArgument String type, @InputArgument String contactInformation) {
        return businessService.addBusiness(name, address, type, contactInformation);
    }

    @DgsMutation
    public Business updateBusiness(@InputArgument Long id, @InputArgument String name, @InputArgument String address, @InputArgument String type, @InputArgument String contactInformation) {
        return businessService.updateBusiness(id, name, address, type, contactInformation);
    }

    @DgsMutation
    public boolean deleteBusiness(@InputArgument Long id) {
        return businessService.deleteBusiness(id);
    }
}
