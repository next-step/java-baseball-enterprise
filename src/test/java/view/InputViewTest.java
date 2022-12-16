package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;

import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    final InputView inputView = new InputViewImpl();


    @Test
    @DisplayName("parsing_line_test")
    void parsingLineTest() throws Exception {
        Method parsingLine = InputViewImpl.class.getDeclaredMethod("parsingLine", String.class);
        parsingLine.setAccessible(true);
        List<Integer> integers = (List<Integer>) parsingLine.invoke(inputView, "123");
        assertThat(integers).contains(1,2,3);
    }

    @Test
    @DisplayName("duplicate_success_test")
    void duplicateSuccessTest() throws Exception{
        Method isDuplicate = InputViewImpl.class.getDeclaredMethod("isDuplicate", String.class);
        isDuplicate.setAccessible(true);
        boolean duplicate = (boolean) isDuplicate.invoke(inputView, "113");
        assertThat(duplicate).isTrue();

    }
    @Test
    @DisplayName("duplicate_fail_test")
    void duplicateFailTest() throws Exception{
        Method isDuplicate = InputViewImpl.class.getDeclaredMethod("isDuplicate", String.class);
        isDuplicate.setAccessible(true);
        boolean isDuplicateResult = (boolean) isDuplicate.invoke(inputView, "123");
        assertThat(isDuplicateResult).isFalse();
    }

    @Test
    @DisplayName("is_number_success_test")
    void isNumberSuccessTest() throws Exception{
        Method isNumber = InputViewImpl.class.getDeclaredMethod("isNumber", String.class);
        isNumber.setAccessible(true);
        boolean isNumberResult = (boolean) isNumber.invoke(inputView, "123");
        assertThat(isNumberResult).isTrue();
    }

    @Test
    @DisplayName("is_number_fail_test")
    void isNumberFailTest() throws Exception{
        Method isNumber = InputViewImpl.class.getDeclaredMethod("isNumber", String.class);
        isNumber.setAccessible(true);
        boolean isNumberResult = (boolean) isNumber.invoke(inputView, "12a");
        assertThat(isNumberResult).isFalse();
    }



    @Test
    @DisplayName("validate_three_number_test_length_fail_test")
    void validateThreeNumberLengthFailTest() throws  Exception{
        Method checkLength = InputViewImpl.class.getDeclaredMethod("checkLength", String.class, Integer.class);
        checkLength.setAccessible(true);
        boolean checkLengthResult = (boolean) checkLength.invoke(inputView, "1234", 3);
        assertThat(checkLengthResult).isFalse();
    }
    @Test
    @DisplayName("validate_three_number_test_length_success_test")
    void validateThreeNumberLengthSuccessTest() throws  Exception{
        Method checkLength = InputViewImpl.class.getDeclaredMethod("checkLength", String.class, Integer.class);
        checkLength.setAccessible(true);
        boolean checkLengthResult = (boolean) checkLength.invoke(inputView, "123",3);
        assertThat(checkLengthResult).isTrue();
    }

    @Test
    @DisplayName("validate_three_number_test_success_test")
    void validateThreeNumberSuccessTest()throws Exception{
        Method validateThreeNumbers = InputViewImpl.class.getDeclaredMethod("validateThreeNumbers", String.class);
        validateThreeNumbers.setAccessible(true);
        boolean validateThreeNumberResult = (boolean) validateThreeNumbers.invoke(inputView, "123");
        assertThat(validateThreeNumberResult).isTrue();
    }

    @Test
    @DisplayName("validate_one_number_bound_success_test")
    void validateOneNumberBoundSuccessTest() throws Exception{
        Method validateOptionBound = InputViewImpl.class.getDeclaredMethod("validateOptionBound", String.class);
        validateOptionBound.setAccessible(true);
        boolean validateResult = (boolean) validateOptionBound.invoke(inputView, "1");
        assertThat(validateResult).isTrue();
        validateResult = (boolean) validateOptionBound.invoke(inputView, "2");
        assertThat(validateResult).isTrue();
    }


    @Test
    @DisplayName("validate_one_number_bound_fail_test")
    void validateOneNumberBoundFailTest() throws Exception{
        Method validateOptionBound = InputViewImpl.class.getDeclaredMethod("validateOptionBound", String.class);
        validateOptionBound.setAccessible(true);
        boolean validateResult = (boolean) validateOptionBound.invoke(inputView, "3");
        assertThat(validateResult).isFalse();

    }



}