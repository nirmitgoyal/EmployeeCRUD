package com.paypal.bfs.test.employeeserv.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The type Employee table.
 */
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class EmployeeTable {
    /**
     * The Id.
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * The First name.
     */
    private String first_name;
    /**
     * The Last name.
     */
    private String last_name;
    /**
     * The Date of birth.
     */
    private String date_of_birth;
    /**
     * The Address line 1.
     */
    private String address_line1;
    /**
     * The Address line 2.
     */
    private String address_line2;
    /**
     * The City.
     */
    private String city;
    /**
     * The State.
     */
    private String state;
    /**
     * The Country.
     */
    private String country;
    /**
     * The Zip code.
     */
    private String zip_code;
}
