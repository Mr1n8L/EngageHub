package com.engagehub.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String serviceName;
    private LocalDateTime appointmentDateTime;
    private String customerName;
    private String customerEmail;
    private String customerPhoneNumber;

    private String status; // e.g., Scheduled, Completed, Cancelled
    private String notes; // Additional notes about the appointment

}
