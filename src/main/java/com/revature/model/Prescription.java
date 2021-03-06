package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "prescription")
public class Prescription {
    @Id
    @Column(name = "prescriptionid")
    @GeneratedValue(generator = "prescription_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(allocationSize = 1, name = "prescription_id_seq", sequenceName = "prescription_id_seq")
    private int id;

    @ManyToOne
    @JoinColumn(name = "medicationid", nullable = false)
    private Medication medication;

    @ManyToOne
    @JoinColumn(name = "prescribedto", nullable = false)
    private Person patient;

    @ManyToOne
    @JoinColumn(name = "prescribedby", nullable = false)
    private Person doctor;

    @Column(nullable = false)
    private double dosage;
}