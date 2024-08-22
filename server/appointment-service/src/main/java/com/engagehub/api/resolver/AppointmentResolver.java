package com.engagehub.api.resolver;

import ccom.engagehub.api.model.Appointment;
import com.engagehub.api.repository.AppointmentRepository;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@DgsComponent
public class AppointmentResolver {

    private final AppointmentRepository appointmentRepository;

    public AppointmentResolver(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @DgsQuery
    public List<Appointment> appointments() {
        return appointmentRepository.findAll();
    }

    @DgsQuery
    public Optional<Appointment> appointment(@InputArgument String id) {
        Long appointmentId = Long.parseLong(id); // Convert String to Long
        return appointmentRepository.findById(appointmentId);
    }
    @DgsMutation
    public Appointment addAppointment(@InputArgument String customerName,
                                      @InputArgument String serviceName,
                                      @InputArgument String appointmentDateTime) {
        LocalDateTime dateTime = LocalDateTime.parse(appointmentDateTime); // Convert String to LocalDateTime
        Appointment appointment = new Appointment(null, customerName, serviceName, dateTime, "BOOKED");
        return appointmentRepository.save(appointment);
    }

    @DgsMutation
    public Appointment updateAppointment(@InputArgument String id,
                                         @InputArgument String customerName,
                                         @InputArgument String serviceName,
                                         @InputArgument String appointmentDateTime) {
        Long appointmentId = Long.parseLong(id); // Convert String to Long
        LocalDateTime dateTime = LocalDateTime.parse(appointmentDateTime); // Convert String to LocalDateTime
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(appointmentId);
        if (appointmentOptional.isPresent()) {
            Appointment existingAppointment = appointmentOptional.get();
            existingAppointment.setCustomerName(customerName);
            existingAppointment.setServiceName(serviceName);
            existingAppointment.setAppointmentDateTime(dateTime);
            return appointmentRepository.save(existingAppointment);
        } else {
            throw new RuntimeException("Appointment not found");
        }
    }

    @DgsMutation
    public Boolean deleteAppointment(@InputArgument String id) {
        Long appointmentId = Long.parseLong(id); // Convert String to Long
        appointmentRepository.deleteById(appointmentId);
        return true;
    }

    @DgsQuery
    public List<Appointment> searchAppointments(
            @InputArgument String customerName,
            @InputArgument String serviceName) {
        return appointmentRepository.findByCustomerNameContainingAndServiceNameContaining(customerName, serviceName);
    }
}