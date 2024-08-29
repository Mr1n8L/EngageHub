package com.engagehub.api.service;

import ccom.engagehub.api.model.Appointment;
import com.engagehub.api.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    public Appointment addAppointment(String customerName, String serviceName, LocalDateTime appointmentDateTime) {
        Appointment appointment = new Appointment(null, customerName, serviceName, appointmentDateTime, "BOOKED");
        return appointmentRepository.save(appointment);
    }

    public Appointment updateAppointment(Long id, String customerName, String serviceName, LocalDateTime appointmentDateTime, String status) {
        return appointmentRepository.findById(id).map(existingAppointment -> {
            existingAppointment.setCustomerName(customerName);
            existingAppointment.setServiceName(serviceName);
            existingAppointment.setAppointmentDateTime(appointmentDateTime);
            existingAppointment.setStatus(status);
            return appointmentRepository.save(existingAppointment);
        }).orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    public List<Appointment> searchAppointments(String customerName, String serviceName) {
        return appointmentRepository.findByCustomerNameContainingAndServiceNameContaining(customerName, serviceName);
    }
}