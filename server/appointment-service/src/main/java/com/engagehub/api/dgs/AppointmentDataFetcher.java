package com.engagehub.api.dgs;

import com.engagehub.api.model.Appointment;
import com.engagehub.api.service.AppointmentService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@DgsComponent
public class AppointmentDataFetcher {

    private final AppointmentService appointmentService;

    public AppointmentDataFetcher(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @DgsQuery
    public List<Appointment> appointments() {
        return appointmentService.findAllAppointments();
    }

    @DgsQuery
    public Optional<Appointment> appointmentById(@InputArgument Long id) {
        return appointmentService.findAppointmentById(id);
    }

    @DgsQuery
    public List<Appointment> searchAppointments(
            @InputArgument String customerName,
            @InputArgument LocalDateTime startDateTime,
            @InputArgument LocalDateTime endDateTime,
            @InputArgument String status) {
        return appointmentService.searchAppointments(customerName, startDateTime, endDateTime, status);
    }

    @DgsMutation
    public Appointment addAppointment(@InputArgument String serviceName,
                                      @InputArgument LocalDateTime appointmentDateTime,
                                      @InputArgument String customerName,
                                      @InputArgument String customerEmail,
                                      @InputArgument String customerPhoneNumber,
                                      @InputArgument String status,
                                      @InputArgument String notes) {
        Appointment appointment = new Appointment(null, serviceName, appointmentDateTime, customerName, customerEmail, customerPhoneNumber, status, notes);
        return appointmentService.saveAppointment(appointment);
    }

    @DgsMutation
    public Appointment updateAppointment(@InputArgument Long id,
                                         @InputArgument String serviceName,
                                         @InputArgument LocalDateTime appointmentDateTime,
                                         @InputArgument String customerName,
                                         @InputArgument String customerEmail,
                                         @InputArgument String customerPhoneNumber,
                                         @InputArgument String status,
                                         @InputArgument String notes) {
        Appointment appointmentDetails = new Appointment(null, serviceName, appointmentDateTime, customerName, customerEmail, customerPhoneNumber, status, notes);
        return appointmentService.updateAppointment(id, appointmentDetails);
    }

    @DgsMutation
    public Boolean deleteAppointment(@InputArgument Long id) {
        appointmentService.deleteAppointment(id);
        return true;
    }
}
