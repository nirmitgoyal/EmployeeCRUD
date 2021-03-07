package com.paypal.bfs.test.employeeserv.errors;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The type Errors.
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
public class Errors {
    /**
     * The Field.
     */
    private String field;
    /**
     * The Message.
     */
    private String message;
}
