package calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    //테스트 독립된 관계 만들기
    //의존관계 가지지 않고 독립된 관계 만듦
    //순서 보장하면서 테스트 만들지 말기.
    @Before
    public void setUp() throws Exception {
        System.out.println("setup");
    }

    @Test
    public void 덧셈() {
        System.out.println("add");
        int result = Calculator.add(1, 2);
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 뺄셈() {
        System.out.println("subtract");
        int result = Calculator.subtract(2, 1);
        assertThat(result).isEqualTo(1);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
    }
}
