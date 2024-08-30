package com.engagehub.api.service;

import com.engagehub.api.model.Business;
import com.engagehub.api.repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusinessService {

	private final BusinessRepository businessRepository;

	@Autowired
	public BusinessService(BusinessRepository businessRepository) {
		this.businessRepository = businessRepository;
	}

	public List<Business> getAllBusinesses() {
		return businessRepository.findAll();
	}

	public Optional<Business> getBusinessById(Long id) {
		return businessRepository.findById(id);
	}

	public Business addBusiness(String name, String address, String type, String contactInformation) {
		Business business = new Business();
		business.setName(name);
		business.setAddress(address);
		business.setType(type);
		business.setContactInformation(contactInformation);
		return businessRepository.save(business);
	}

	public Business updateBusiness(Long id, String name, String address, String type, String contactInformation) {
		Optional<Business> existingBusiness = businessRepository.findById(id);
		if (existingBusiness.isPresent()) {
			Business business = existingBusiness.get();
			business.setName(name);
			business.setAddress(address);
			business.setType(type);
			business.setContactInformation(contactInformation);
			return businessRepository.save(business);
		}
		throw new RuntimeException("Business not found");
	}

	public boolean deleteBusiness(Long id) {
		Optional<Business> existingBusiness = businessRepository.findById(id);
		if (existingBusiness.isPresent()) {
			businessRepository.delete(existingBusiness.get());
			return true;
		}
		return false;
	}
}
