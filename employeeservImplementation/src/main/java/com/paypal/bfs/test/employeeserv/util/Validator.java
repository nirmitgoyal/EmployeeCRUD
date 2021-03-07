package com.paypal.bfs.test.employeeserv.util;


import com.paypal.bfs.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.errors.Errors;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Validator.
 */
@Component
public class Validator {

    /**
     * The constant FIRST_NAME.
     */
    public static final String FIRST_NAME = "First Name";
    /**
     * The constant LAST_NAME.
     */
    public static final String LAST_NAME = "Last Name";
    /**
     * The constant DATE_OF_BIRTH.
     */
    public static final String DATE_OF_BIRTH = "Date of Birth";
    /**
     * The constant ADDRESS_LINE_1.
     */
    public static final String ADDRESS_LINE_1 = "Address Line 1";
    /**
     * The constant ADDRESS_LINE_2.
     */
    public static final String ADDRESS_LINE_2 = "Address Line 2";
    /**
     * The constant CITY.
     */
    public static final String CITY = "City";
    /**
     * The constant STATE.
     */
    public static final String STATE = "State";
    /**
     * The constant ZIP_CODE.
     */
    public static final String ZIP_CODE = "zip code";
    /**
     * The constant COUNTRY.
     */
    public static final String COUNTRY = "Country";
    /**
     * The constant MAX_LENGTH.
     */
    public static final int MAX_LENGTH = 255;
    /**
     * The constant REQUIRED.
     */
    public static final String REQUIRED = "Required";
    /**
     * The constant MAX_LENGTH_IS.
     */
    public static final String MAX_LENGTH_IS = "Max length is ";


    /**
     * Validate optional.
     *
     * @param employee the employee
     * @return the optional
     */
    public Optional<List<Errors>> validate(Employee employee) {
        List<Errors> errorsList = new ArrayList<>();

        checkForRequired(employee,errorsList);
        checkForLength(employee,errorsList);

        return errorsList.size() > 0 ? Optional.of(errorsList) : Optional.empty();
    }

    /**
     * Check for length.
     *
     * @param employee   the employee
     * @param errorsList the errors list
     */
    private void checkForLength(Employee employee, List<Errors> errorsList) {
        if (isValidLength(employee.getFirstName(), MAX_LENGTH))
            errorsList.add(Errors.builder()
                    .field(FIRST_NAME)
                    .message(MAX_LENGTH_IS + MAX_LENGTH)
                    .build());

        if (isValidLength(employee.getLastName(), MAX_LENGTH))
            errorsList.add(Errors.builder()
                    .field(LAST_NAME)
                    .message(MAX_LENGTH_IS + MAX_LENGTH)
                    .build());

        if (isValidLength(employee.getAddressLine1(), MAX_LENGTH))
            errorsList.add(Errors.builder()
                    .field(ADDRESS_LINE_1)
                    .message(MAX_LENGTH_IS + MAX_LENGTH)
                    .build());

        if (isValidLength(employee.getAddressLine2(), MAX_LENGTH))
            errorsList.add(Errors.builder()
                    .field(ADDRESS_LINE_2)
                    .message(MAX_LENGTH_IS + MAX_LENGTH)
                    .build());

        if (isValidLength(employee.getCountry(), MAX_LENGTH))
            errorsList.add(Errors.builder()
                    .field(COUNTRY)
                    .message(MAX_LENGTH_IS + MAX_LENGTH)
                    .build());

        if (isValidLength(employee.getState(), MAX_LENGTH))
            errorsList.add(Errors.builder()
                    .field(STATE)
                    .message(MAX_LENGTH_IS + MAX_LENGTH)
                    .build());

        if (isValidLength(employee.getZipCode(), 10))
            errorsList.add(Errors.builder()
                    .field(ZIP_CODE)
                    .message(MAX_LENGTH_IS + 10)
                    .build());
    }

    /**
     * Check for required.
     *
     * @param employeeRequest the employee request
     * @param errorsList      the errors list
     */
    private void checkForRequired(Employee employeeRequest, List<Errors> errorsList) {
        if (isEmpty(employeeRequest.getFirstName()))
            errorsList.add(Errors.builder()
                    .field(FIRST_NAME)
                    .message(REQUIRED)
                    .build());

        if (isEmpty(employeeRequest.getLastName()))
            errorsList.add(Errors.builder()
                    .field(LAST_NAME)
                    .message(REQUIRED)
                    .build());

        if (isEmpty(employeeRequest.getDateOfBirth()))
            errorsList.add(Errors.builder()
                    .field(DATE_OF_BIRTH)
                    .message(REQUIRED)
                    .build());

        if (isEmpty(employeeRequest.getAddressLine1()))
            errorsList.add(Errors.builder()
                    .field(ADDRESS_LINE_1)
                    .message(REQUIRED)
                    .build());

        if (isEmpty(employeeRequest.getCity()))
            errorsList.add(Errors.builder()
                    .field(CITY)
                    .message(REQUIRED)
                    .build());

        if (isEmpty(employeeRequest.getState()))
            errorsList.add(Errors.builder()
                    .field(STATE)
                    .message(REQUIRED)
                    .build());

        if (isEmpty(employeeRequest.getZipCode()))
            errorsList.add(Errors.builder()
                    .field(ZIP_CODE)
                    .message(REQUIRED)
                    .build());

        if (isEmpty(employeeRequest.getCountry()))
            errorsList.add(Errors.builder()
                    .field(COUNTRY)
                    .message(REQUIRED)
                    .build());
    }

    /**
     * Is valid length boolean.
     *
     * @param value     the value
     * @param maxLength the max length
     * @return the boolean
     */
    private boolean isValidLength(String value, int maxLength) {
        return !isEmpty(value) && value.length() > maxLength;
    }

    /**
     * Is empty boolean.
     *
     * @param value the value
     * @return the boolean
     */
    private boolean isEmpty(String value) {
        return value == null;
    }

}
