package bridge.service;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

public class BridgeServiceTest extends NsTest {

    @DisplayName("게임을 실패했을 때 다리 출력 결과 테스트")
    @Test
    void resultBridgePrintTest() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "U", "D", "Q");
            assertThat(output()).contains(
                "[   | O |   ]",
                "[ O |   | X ]",
                "실패"
            );
        }, 0, 1, 1);
    }


    @DisplayName("게임 시도 횟수 테스트")
    @Test
    void gameTrialTest() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "U", "D", "R", "U", "R", "D", "U", "U");
            assertThat(output()).contains("3");
        }, 0, 1, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});

    }

}
