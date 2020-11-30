package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {
    
    @Test
    @DisplayName("요구사항 1 : \"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
    public void splitContains() {
        //given
        String string = "1,2";
        
        //when
        String[] strings = string.split(",");

        //then
        assertThat(strings).contains("1", "2");
    }

    @Test
    @DisplayName("요구사항 1 : \"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    public void splitContatinsExactly() {
        //given
        String string = "1";

        //when
        String[] strings = string.split(",");

        //then
        assertThat(strings).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항 2 : \"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현한다.")
    public void substring() {
        //given
        String string = "(1,2)";

        //when
        String substring = string.substring(1, string.length()-1);

        //then
        assertEquals(substring, "1,2");
    }
    
    @DisplayName("요구사항 3 : \"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
    @ParameterizedTest
    @CsvSource(value = {"0,a", "1,b", "2,c"})
    public void charAt(int input, char expected) {
        //given
        String string = "abc";
        
        //when
        char letter = string.charAt(input);

        //then
        assertEquals(letter, expected);
    }
    
    @Test
    @DisplayName("요구사항 3 : String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.")
    public void StringIndexOutOfBoundsException() {
        //given
        String string = "abc";
        int out = 1;
        int outRange = string.length() + out;
        
        //when
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> string.charAt(outRange))
                .withMessageMatching("String index out of range: 4");
    }
}
