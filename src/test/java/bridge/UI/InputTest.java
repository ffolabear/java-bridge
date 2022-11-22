package bridge.UI;

import bridge.Application;
import bridge.view.Errors;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

public class InputTest extends NsTest {

    @DisplayName("다리 길이 입력 테스트")
    @Nested
    class BridgeLengthInputTest {

        @DisplayName("다리 길이가 숫자가 아닐때")
        @ParameterizedTest
        @ValueSource(strings = {"abc", " ", "가나", "ab cd"})
        void isInputDigit(String input) {
            assertSimpleTest(() -> {
                runException(input);
                assertThat(output()).contains(Errors.ERROR_NON_DIGIT.getError());
            });
        }


        @DisplayName("다리 길이가 범위를 벗어날 때")
        @ParameterizedTest
        @ValueSource(longs = {1, 2, 21, 33, Long.MAX_VALUE})
        void isInputDigit(long input) {
            assertSimpleTest(() -> {
                runException(String.valueOf(input));
                assertThat(output()).contains(Errors.ERROR_INVALID_BRIDGE_LENGTH.getError());
            });
        }

    }

    @DisplayName("게임 명령어 입력 테스트")
    @Nested
    class GameCommandTest {

        @DisplayName("움직임 명령어가 지정한 형식이 아닐 때")
        @ParameterizedTest
        @ValueSource(strings = {"1", "UU", "DD", " "})
        void moveCommandTest(String input) {
            assertSimpleTest(() -> {
                runException("3", input);
                assertThat(output()).contains(Errors.ERROR_INVALID_GAME_COMMAND.getError());
            });
        }


        @DisplayName("재시도 명령어가 지정한 형식이 아닐 때")
        @ParameterizedTest
        @ValueSource(strings = {"1", "QQ", "RR", " "})
        void retryCommandTest(String input) {
            assertRandomNumberInRangeTest(() -> {
                runException("3", "U", "U" ,"U", input);
                assertThat(output()).contains(Errors.ERROR_INVALID_REPLAY_COMMAND.getError());
            }, 1, 1, 0);
        }


    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }


}
