package util;

import com.paypal.bfs.test.employeeserv.errors.Errors;
import com.paypal.bfs.test.employeeserv.util.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.paypal.bfs.test.employeeserv.util.Validator.DATE_OF_BIRTH;
import static com.paypal.bfs.test.employeeserv.util.Validator.REQUIRED;
import static data.TestData.INVALID_TEST_EMPLOYEE;
import static data.TestData.TEST_EMPLOYEE;

class ValidatorTest {
    @Mock
    List<Errors> errorsList;
    @InjectMocks
    Validator validator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testValidate() {
        Optional<List<Errors>> result = validator.validate(TEST_EMPLOYEE);
        Assertions.assertEquals(Optional.empty(), result);
    }

    @Test
    void testValidate_DOBMissing() {
        Optional<List<Errors>> result = validator.validate(INVALID_TEST_EMPLOYEE);
        Assertions.assertEquals(Optional.of(Arrays.asList(new Errors(DATE_OF_BIRTH,REQUIRED))), result);
    }
}
