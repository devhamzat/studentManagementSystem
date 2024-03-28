package org.devhamzat.enrollment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @SequenceGenerator(name = "address_id_sequence", sequenceName = "address_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_id_sequence")
    @Column(name = "id",nullable = false)
    private Long id;
    @Column(name = "house_number",nullable = false)
    private int houseNumber;
    @Column(name = "street",nullable = false)
    private String street;
    @Column(name = "city")
    private String city;
    @Column(name = "state",nullable = false)
    private String state;
    @Column(name = "country", nullable = false)
    private String country;
    @OneToOne(mappedBy = "address")
    private Candidate candidate;
}
