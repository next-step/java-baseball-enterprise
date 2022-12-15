package generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class ThreeNumberGeneratorTest {

    private final ThreeNumberGenerator threeNumberGenerator = new ThreeNumberGeneratorImpl();

    @Test
    @DisplayName("random_number_generate_test")
    void randomNumberGenerateTest() throws Exception{
        Method getRandomNumber = ThreeNumberGeneratorImpl.class.getDeclaredMethod("getRandomNumber");
        getRandomNumber.setAccessible(true);
        Integer randomNumber = (Integer)getRandomNumber.invoke(threeNumberGenerator);
        assertThat(randomNumber).isGreaterThanOrEqualTo(1);
        assertThat(randomNumber).isLessThanOrEqualTo(9);
    }

    @Test
    @DisplayName("validate_fail_test")
    void validateFailTest() throws  Exception{
        List<Integer> integers = Arrays.asList(4,3);
        Method validate = ThreeNumberGeneratorImpl.class.getDeclaredMethod("validate", int.class, List.class);
        validate.setAccessible(true);
        boolean result = (boolean)validate.invoke(threeNumberGenerator, 4, integers);
        assertThat(result).isEqualTo(false);
    }
    @Test
    @DisplayName("validate_success_test")
    void validateSuccessTest() throws  Exception{
        List<Integer> integers = Arrays.asList(4,3);
        Method validate = ThreeNumberGeneratorImpl.class.getDeclaredMethod("validate", int.class, List.class);
        validate.setAccessible(true);
        boolean result = (boolean)validate.invoke(threeNumberGenerator, 1, integers);
        assertThat(result).isEqualTo(true);
    }
    @Test
    @DisplayName("add_fail_test")
    void addFailTest() throws  Exception{
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(3);
        integers.add(4);
        Method add = ThreeNumberGeneratorImpl.class.getDeclaredMethod("add", int.class, List.class);
        add.setAccessible(true);
        add.invoke(threeNumberGenerator, 3, integers);
        assertThat(integers.size()).isEqualTo(2);

    }
    @Test
    @DisplayName("add_success_test")
    void addSuccessTest() throws  Exception{
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(3);
        integers.add(4);
        Method add = ThreeNumberGeneratorImpl.class.getDeclaredMethod("add", int.class, List.class);
        add.setAccessible(true);
        add.invoke(threeNumberGenerator, 1, integers);
        assertThat(integers).contains(1,3,4);
    }

    @Test
    @DisplayName("generate_test")
    void generateTest(){
        List<Integer> integers = threeNumberGenerator.generate();
        assertThat(integers.size()).isEqualTo(3);
    }

}