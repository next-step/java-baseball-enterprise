package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        Method lengthIsThree = InputViewImpl.class.getDeclaredMethod("lengthIsThree", String.class);
        lengthIsThree.setAccessible(true);
        boolean lengthIsThreeResult = (boolean) lengthIsThree.invoke(inputView, "1234");
        assertThat(lengthIsThreeResult).isFalse();
    }
    @Test
    @DisplayName("validate_three_number_test_length_success_test")
    void validateThreeNumberLengthSuccessTest() throws  Exception{
        Method lengthIsThree = InputViewImpl.class.getDeclaredMethod("lengthIsThree", String.class);
        lengthIsThree.setAccessible(true);
        boolean lengthIsThreeResult = (boolean) lengthIsThree.invoke(inputView, "123");
        assertThat(lengthIsThreeResult).isTrue();
    }

    @Test
    @DisplayName("validate_three_number_test_success_test")
    void validateThreeNumberSuccessTest()throws Exception{
        Method validateThreeNumbers = InputViewImpl.class.getDeclaredMethod("validateThreeNumbers", String.class);
        validateThreeNumbers.setAccessible(true);
        boolean validateThreeNumberResult = (boolean) validateThreeNumbers.invoke(inputView, "123");
        assertThat(validateThreeNumberResult).isTrue();
    }


}