package com.bukowskiprzemyslaw.tutorisaweb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tbl_tutors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tutor {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long tutorId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
