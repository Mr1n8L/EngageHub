package com.microservice.service.dgs;

import com.microservice.service.model.Appointment;
import com.microservice.service.repository.AppointmentRepository;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@DgsComponent
public class AppointmentDataFetcher {

    private final AppointmentRepository appointmentRepository;

    public AppointmentDataFetcher(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @DgsQuery
    public List<Appointment> appointments() {
        return appointmentRepository.findAll();
    }

    @DgsQuery
    public Optional<Appointment> appointmentById(@InputArgument String id) {  // Changed from Long to String
        Long appointmentId = Long.parseLong(id); // Convert String id to Long
        return appointmentRepository.findById(appointmentId);
    }

    @DgsMutation
    public Appointment addAppointment(@InputArgument String customerName,
                                      @InputArgument String serviceName,
                                      @InputArgument String appointmentDateTime) {  // Changed LocalDateTime to String
        LocalDateTime dateTime = LocalDateTime.parse(appointmentDateTime, DateTimeFormatter.ISO_DATE_TIME);
        Appointment appointment = new Appointment(null, customerName, serviceName, dateTime, "BOOKED");
        return appointmentRepository.save(appointment);
    }

    @DgsMutation
    public Appointment updateAppointment(@InputArgument String id,
                                         @InputArgument String customerName,
                                         @InputArgument String serviceName,
                                         @InputArgument String appointmentDateTime,
                                         @InputArgument String status) {  // Added status to match the mutation schema

        Long appointmentId = Long.parseLong(id); // Convert String id to Long
        LocalDateTime dateTime = LocalDateTime.parse(appointmentDateTime, DateTimeFormatter.ISO_DATE_TIME);

        return appointmentRepository.findById(appointmentId).map(existingAppointment -> {
            existingAppointment.setCustomerName(customerName);
            existingAppointment.setServiceName(serviceName);
            existingAppointment.setAppointmentDateTime(dateTime);
            existingAppointment.setStatus(status);
            return appointmentRepository.save(existingAppointment);
        }).orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    @DgsMutation
    public Boolean deleteAppointment(@InputArgument String id) {  // Changed from Long to String
        Long appointmentId = Long.parseLong(id); // Convert String id to Long
        appointmentRepository.deleteById(appointmentId);
        return true;
    }
}