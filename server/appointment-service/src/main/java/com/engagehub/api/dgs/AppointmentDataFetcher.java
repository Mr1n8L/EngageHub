package com.engagehub.api.dgs;

import com.engagehub.api.model.Appointment;
import com.engagehub.api.repository.AppointmentRepository;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@DgsComponent
public class AppointmentDataFetcher {

    @Autowired
    private AppointmentRepository appointmentRepository;

    // 1. Book an Appointment
    @DgsData(parentType = "Mutation", field = "bookAppointment")
    public Appointment bookAppointment(@InputArgument LocalDateTime dateTime,
                                       @InputArgument String service,
                                       @InputArgument String customerName,
                                       @InputArgument String customerEmail,
                                       @InputArgument String customerPhoneNumber) {
        // Check for available slots before booking
        List<Appointment> existingAppointments = appointmentRepository.findByDateTime(dateTime);
        if (!existingAppointments.isEmpty()) {
            throw new RuntimeException("The selected time slot is not available. Please choose a different time.");
        }

        // Save the appointment
        Appointment appointment = new Appointment();
        appointment.setDateTime(dateTime);
        appointment.setService(service);
        appointment.setCustomerName(customerName);
        appointment.setCustomerEmail(customerEmail);
        appointment.setCustomerPhoneNumber(customerPhoneNumber);
        appointment.setConfirmed(true);
        appointment.setCancelled(false);
        appointment.setReminderSent(false);

        //Todo: Send confirmation notification to the customer

        return appointmentRepository.save(appointment);
    }

    // 2. View Appointments
    @DgsData(parentType = "Query", field = "allAppointments")
    public List<Appointment> allAppointments(@InputArgument String filterByDate,
                                             @InputArgument String filterByService,
                                             @InputArgument String filterByCustomer) {
        if (filterByDate != null && filterByService == null && filterByCustomer == null) {
            return appointmentRepository.findByDate(filterByDate);
        } else if (filterByService != null && filterByDate == null && filterByCustomer == null) {
            return appointmentRepository.findByService(filterByService);
        } else if (filterByCustomer != null && filterByDate == null && filterByService == null) {
            return appointmentRepository.findByCustomerName(filterByCustomer);
        } else {
            return appointmentRepository.findAll();
        }
    }

    // 3. Update an Appointment
    @DgsData(parentType = "Mutation", field = "updateAppointment")
    public Appointment updateAppointment(@InputArgument Long id,
                                         @InputArgument LocalDateTime newDateTime,
                                         @InputArgument String newService) {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(id);
        if (appointmentOptional.isPresent()) {
            Appointment appointment = appointmentOptional.get();

            // Check for slot availability before updating
            List<Appointment> existingAppointments = appointmentRepository.findByDateTime(newDateTime);
            if (!existingAppointments.isEmpty() && !existingAppointments.contains(appointment)) {
                throw new RuntimeException("The selected time slot is not available. Please choose a different time.");
            }

            appointment.setDateTime(newDateTime);
            appointment.setService(newService);
            appointment.setConfirmed(true);

            //todo: Send update notification to the customer and business

            return appointmentRepository.save(appointment);
        } else {
            throw new RuntimeException("Appointment not found.");
        }
    }

    // 4. Cancel an Appointment
    @DgsData(parentType = "Mutation", field = "cancelAppointment")
    public String cancelAppointment(@InputArgument Long id) {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(id);
        if (appointmentOptional.isPresent()) {
            Appointment appointment = appointmentOptional.get();
            appointment.setCancelled(true);
            appointmentRepository.save(appointment);

            // todo: Send cancellation notification to the customer and business

            return "Appointment cancelled successfully.";
        } else {
            throw new RuntimeException("Appointment not found.");
        }
    }
}
