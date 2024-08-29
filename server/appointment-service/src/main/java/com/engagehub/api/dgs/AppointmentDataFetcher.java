
package com.engagehub.api.dgs;
import com.engagehub.api.model.Appointment;
import com.engagehub.api.repository.AppointmentRepository;
import com.engagehub.api.service.AppointmentService;
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

    private final AppointmentService appointmentService;

    public AppointmentDataFetcher(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @DgsQuery
    public List<Appointment> appointments() {
        return appointmentService.getAllAppointments();
    }

    @DgsQuery
    public Appointment appointment(@InputArgument String id) {
        Long appointmentId = Long.parseLong(id);
        return appointmentService.getAppointmentById(appointmentId).orElse(null);
    }

    @DgsQuery
    public List<Appointment> searchAppointments(@InputArgument String customerName, @InputArgument String serviceName) {
        return appointmentService.searchAppointments(customerName, serviceName);
    }

    @DgsMutation
    public Appointment addAppointment(@InputArgument String customerName,
                                      @InputArgument String serviceName,
                                      @InputArgument String appointmentDateTime) {
        LocalDateTime dateTime = LocalDateTime.parse(appointmentDateTime, DateTimeFormatter.ISO_DATE_TIME);
        return appointmentService.addAppointment(customerName, serviceName, dateTime);
    }

    @DgsMutation
    public Appointment updateAppointment(@InputArgument String id,
                                         @InputArgument String customerName,
                                         @InputArgument String serviceName,
                                         @InputArgument String appointmentDateTime,
                                         @InputArgument String status) {
        Long appointmentId = Long.parseLong(id);
        LocalDateTime dateTime = LocalDateTime.parse(appointmentDateTime, DateTimeFormatter.ISO_DATE_TIME);
        return appointmentService.updateAppointment(appointmentId, customerName, serviceName, dateTime, status);
    }

    @DgsMutation
    public Boolean deleteAppointment(@InputArgument String id) {
        Long appointmentId = Long.parseLong(id);
        appointmentService.deleteAppointment(appointmentId);
        return true;
    }
}