package com.engagehub.api.business.dgs;

import com.engagehub.api.business.model.Business;
import com.engagehub.api.business.service.BusinessService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;

import java.util.List;

@DgsComponent
public class BusinessDataFetcher {

    private final BusinessService businessService;

    public BusinessDataFetcher(BusinessService businessService) {
        this.businessService = businessService;
    }

    @DgsData(parentType = "Query", field = "businesses")
    public List<Business> getBusinesses() {
        return businessService.getAllBusinesses();
    }

    @DgsData(parentType = "Query", field = "business")
    public Business getBusiness(@InputArgument Long id) {
        return businessService.getBusinessById(id).orElse(null);
    }

    @DgsData(parentType = "Mutation", field = "addBusiness")
    public Business addBusiness(@InputArgument String name, @InputArgument String address,
                                @InputArgument String type, @InputArgument String contactInfo) {
        Business business = new Business();
        business.setName(name);
        business.setAddress(address);
        business.setType(type);
        business.setContactInfo(contactInfo);
        return businessService.addBusiness(business);
    }

    @DgsData(parentType = "Mutation", field = "updateBusiness")
    public Business updateBusiness(@InputArgument Long id, @InputArgument String name,
                                   @InputArgument String address, @InputArgument String type,
                                   @InputArgument String contactInfo) {
        Business updatedBusiness = new Business();
        updatedBusiness.setName(name);
        updatedBusiness.setAddress(address);
        updatedBusiness.setType(type);
        updatedBusiness.setContactInfo(contactInfo);
        return businessService.updateBusiness(id, updatedBusiness);
    }

    @DgsData(parentType = "Mutation", field = "deleteBusiness")
    public Boolean deleteBusiness(@InputArgument Long id) {
        businessService.deleteBusiness(id);
        return true;
    }
}
