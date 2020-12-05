package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @DisplayName("자동차는 전진 하거나 멈출 수 있다")
    @ParameterizedTest
    @CsvSource(value = {"0, 0", "4, 1", "9, 1"})
    public void move(int condition, int expected){
        //given
        Car car = new Car();

        //when
        car.move(condition);

        //then
        assertEquals(car.getPosition(), expected);
    }

    @DisplayName("0 ~ 9 사이의 random 값을 구한 후 random 값이 4이상일 경우 전진한다")
    @ParameterizedTest
    @CsvSource(value = {"0, 0", "4, 1", "9, 1"})
    public void movingCar(int randomCondition, int expected) {
        //given
        Car car = new Car();
        FixedCondition fixedCondition = new FixedCondition(randomCondition);

        //when
        car.move(fixedCondition.getCondition());
        
        //then
        assertEquals(car.getPosition(), expected);
    }
}
