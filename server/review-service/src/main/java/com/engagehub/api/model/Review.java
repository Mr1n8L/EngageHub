package com.engagehub.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long customerId;

    @Column(nullable = false)
    private Long businessId;

    @Column(nullable = false)
    private int rating;

    private String comment;

    private String response;

    // Default constructor
    public Review() {
    }

    // Constructor with fields
    public Review(Long customerId, Long businessId, int rating, String comment) {
        this.customerId = customerId;
        this.businessId = businessId;
        this.rating = rating;
        this.comment = comment;
    }
}
