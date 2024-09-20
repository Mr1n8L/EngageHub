package com.engagehub.api.repository;
import com.engagehub.api.model.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//extending JPA Repository
@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {
}
