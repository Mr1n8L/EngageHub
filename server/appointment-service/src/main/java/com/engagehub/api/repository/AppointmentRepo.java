package com.engagehub.api.repository;

import com.engagehub.api.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByDateTime(LocalDateTime dateTime);

    List<Appointment> findByDate(String date);

    List<Appointment> findByService(String service);

    List<Appointment> findByCustomerName(String customerName);
}
