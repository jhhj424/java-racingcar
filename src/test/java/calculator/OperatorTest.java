package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1, +, 2, 3", "-1, +, -2, -3", "-9, +, 0, -9", "0, +, 0, 0"})
    @DisplayName("두 수의 덧셈 연산 테스트")
    public void plus(int first, String operator, int second, int expected){
        //when
        int result = Operator.getOperator(operator).calculate(first, second);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, -, 2, -1", "-1, -, -2, 1", "-9, -, 0, -9", "0, -, 0, 0"})
    @DisplayName("두 수의 뺄셈 연산 테스트")
    public void minus(int first, String operator, int second, int expected){
        //when
        int result = Operator.getOperator(operator).calculate(first, second);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, *, 2, 2", "-1, *, -2, 2", "-9, *, 0, 0", "0, *, 0, 0"})
    @DisplayName("두 수의 곱셈 연산 테스트")
    public void multiply(int first, String operator, int second, int expected){
        //when
        int result = Operator.getOperator(operator).calculate(first, second);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, /, 2, 0", "5, /, 2, 2", "-6, /, 3, -2"})
    @DisplayName("두 수의 나눗셈 연산 테스트 - 결과 값은 정수로 한정")
    public void divide(int first, String operator, int second, int expected){
        //when
        int result = Operator.getOperator(operator).calculate(first, second);

        //then
        assertThat(result).isEqualTo(expected);
    }
}
