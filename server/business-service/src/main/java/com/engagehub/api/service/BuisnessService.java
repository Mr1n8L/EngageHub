package com.engagehub.api.business.service;

import com.engagehub.api.business.model.Business;
import com.engagehub.api.business.repository.BusinessRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusinessService {

    private final BusinessRepository businessRepository;

    public BusinessService(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    public List<Business> getAllBusinesses() {
        return businessRepository.findAll();
    }

    public Optional<Business> getBusinessById(Long id) {
        return businessRepository.findById(id);
    }

    public Business addBusiness(Business business) {
        return businessRepository.save(business);
    }

    public Business updateBusiness(Long id, Business updatedBusiness) {
        return businessRepository.findById(id)
                .map(business -> {
                    business.setName(updatedBusiness.getName());
                    business.setAddress(updatedBusiness.getAddress());
                    business.setType(updatedBusiness.getType());
                    business.setContactInfo(updatedBusiness.getContactInfo());
                    return businessRepository.save(business);
                })
                .orElseThrow(() -> new RuntimeException("Business not found"));
    }

    public void deleteBusiness(Long id) {
        businessRepository.deleteById(id);
    }
}
