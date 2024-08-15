package com.engagehub.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.engagehub.crm.business.model.Business;

public interface BusinessRepository extends JpaRepository<Business, Long> {
}
