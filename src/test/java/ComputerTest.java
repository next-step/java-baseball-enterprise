import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {
    @Test
    void contains() {
        int[] numbers = {4,5,2};
        Computer computer = new Computer(numbers);

        for (int number : numbers) {
            assertThat(computer.contains(number)).isTrue();
        }
    }

    @Test
    void getUniqueNumber() {
        int[] numbers = {4,7,1};
        Computer computer = new Computer(numbers);

        int unique = computer.getUniqueNumber();
        for (int number : numbers) {
            assertThat(unique).isNotEqualTo(number);
        }
    }

    @Test
    void selectNumbers() {
        Computer computer = new Computer();

        computer.selectNumbers();
        int count = 0;
        for (int i = 0; i<10; i++) {
            count = computer.contains(i) ? count+1 : count;
        }
        assertThat(count).isEqualTo(3);
    }

    @Test
    void isStrike() {
        int[] numbers = {1, 7, 3};
        Computer computer = new Computer(numbers);

        assertThat(computer.isStrike(1, 0)).isEqualTo(1);
        assertThat(computer.isStrike(7, 1)).isEqualTo(1);
        assertThat(computer.isStrike(3, 2)).isEqualTo(1);

        assertThat(computer.isStrike(5, 2)).isEqualTo(0);
        assertThat(computer.isStrike(7, 0)).isEqualTo(0);
    }

    @Test
    void isBall() {
        int[] numbers = {9, 1, 2};
        Computer computer = new Computer(numbers);

        assertThat(computer.isBall(1, 0)).isEqualTo(1);
        assertThat(computer.isBall(9, 2)).isEqualTo(1);

        assertThat(computer.isBall(9, 0)).isEqualTo(0);
        assertThat(computer.isBall(7, 0)).isEqualTo(0);

    }

    @Test
    void calculate() {
        int[] numbers = {8,6,4};
        Computer computer = new Computer(numbers);

        int[] inputs1 = {5,6,8};
        assertThat(computer.calculate(inputs1)).containsExactly(1, 1); // 1 strike 1 ball
        int[] inputs2 = {6,8,1};
        assertThat(computer.calculate(inputs2)).containsExactly(0, 2); // 0 strike 2 ball
    }
}