package com.engagehub.api.business.repository;

import com.engagehub.api.business.model.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository<Business, Long> {
}
