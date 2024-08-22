package com.microservice.service.repository;

import com.microservice.service.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByCustomerNameContaining(String customerName);

    List<Appointment> findByAppointmentDateTimeBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);

    List<Appointment> findByStatus(String status);

    List<Appointment> findByCustomerNameContainingAndServiceNameContaining(String customerName, String serviceName);


}