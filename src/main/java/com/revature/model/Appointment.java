package com.revature.model;

import java.sql.Date;

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
@Table(name = "appointment")
public class Appointment {
    @Id
    @Column(name = "appointmentid")
    @GeneratedValue(generator = "appoint_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(allocationSize = 1, name = "appoint_id_seq", sequenceName = "appoint_id_seq")
    private int id;

    
    @ManyToOne
    @JoinColumn(name = "patientid")
    private Person patient;

    @ManyToOne
    @JoinColumn(name = "doctorid")
    private Person doctor;

    @Column(name = "date")
    private Date date;

    @Column(name = "status")
    private String status;

    @Column(name = "comment")
    private String comment;
}
