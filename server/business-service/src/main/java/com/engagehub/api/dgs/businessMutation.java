package com.engagehub.api.dgs;


import com.engagehub.api.model;
import com.engagehub.api.repository.businessRepository;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;

@DgsComponent
public class BusinessMutation {

    private final BusinessRepository businessRepository;

    public BusinessMutation(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    @DgsMutation
    public Business addBusiness(Business business) {
        return businessRepository.save(business);
    }

    @DgsMutation
    public Business updateBusiness(Long id, Business updatedBusiness) {
        Business business = businessRepository.findById(id).orElseThrow(() -> new RuntimeException("Business not found"));
        business.setName(updatedBusiness.getName());
        business.setAddress(updatedBusiness.getAddress());
        business.setType(updatedBusiness.getType());
        business.setContactInfo(updatedBusiness.getContactInfo());
        return businessRepository.save(business);
    }

    @DgsMutation
    public Boolean deleteBusiness(Long id) {
        businessRepository.deleteById(id);
        return true;
    }
}
