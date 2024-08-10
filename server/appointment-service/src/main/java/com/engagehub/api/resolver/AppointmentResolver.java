package com.engagehub.api.resolver;

import com.engagehub.api.model.Appointment;
import com.engagehub.api.repository.appointmentRepo;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@DgsComponent
public class AppointmentResolver {

    @Autowired
    private appointmentRepo appointmentRepo;

    // Query Resolver for fetching all appointments
    @DgsData(parentType = "Query", field = "allAppointments")
    public List<Appointment> allAppointments() {
        return appointmentRepo.findAll();
    }

    // Query Resolver for fetching an appointment by ID
    @DgsData(parentType = "Query", field = "appointmentById")
    public Appointment getAppointmentById(@InputArgument Long id) {
        return appointmentRepo.findById(id).orElse(null);
    }

    // Mutation Resolver for creating a new appointment
    @DgsData(parentType = "Mutation", field = "createAppointment")
    public Appointment createAppointment(@InputArgument("input") AppointmentInput input) {
        Appointment appointment = new Appointment();
        appointment.setDateTime(LocalDateTime.parse(input.getDateTime()));
        appointment.setService(input.getService());
        appointment.setCustomerName(input.getCustomerName());
        appointment.setCustomerEmail(input.getCustomerEmail());
        appointment.setCustomerPhoneNumber(input.getCustomerPhoneNumber());
        appointment.setConfirmed(input.isConfirmed());
        appointment.setCancelled(input.isCancelled());
        appointment.setReminderSent(input.isReminderSent());
        return appointmentRepo.save(appointment);
    }

    // Mutation Resolver for updating an existing appointment
    @DgsData(parentType = "Mutation", field = "updateAppointment")
    public Appointment updateAppointment(@InputArgument Long id, @InputArgument("input") AppointmentInput input) {
        Optional<Appointment> appointmentOptional = appointmentRepo.findById(id);
        if (appointmentOptional.isPresent()) {
            Appointment appointment = appointmentOptional.get();
            appointment.setDateTime(LocalDateTime.parse(input.getDateTime()));
            appointment.setService(input.getService());
            appointment.setCustomerName(input.getCustomerName());
            appointment.setCustomerEmail(input.getCustomerEmail());
            appointment.setCustomerPhoneNumber(input.getCustomerPhoneNumber());
            appointment.setConfirmed(input.isConfirmed());
            appointment.setCancelled(input.isCancelled());
            appointment.setReminderSent(input.isReminderSent());
            return appointmentRepo.save(appointment);
        }
        return null;
    }

    // Mutation Resolver for deleting an appointment
    @DgsData(parentType = "Mutation", field = "deleteAppointment")
    public Boolean deleteAppointment(@InputArgument Long id) {
        if (appointmentRepo.existsById(id)) {
            appointmentRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
