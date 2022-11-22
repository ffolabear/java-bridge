package bridge.UI;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class OutputTest extends NsTest {

    @DisplayName("게임 진행 메세지 출력 테스트")
    @Test
    void gameSystemMessageTest() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "U", "D", "R", "D", "U", "U");
            assertThat(output()).contains(
                "다리 건너기 게임을 시작합니다.",
                "다리의 길이를 입력해주세요.",
                "이동할 칸을 선택해주세요. (위: U, 아래: D)",
                "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                "최종 게임 결과"
            );
        }, 0, 1, 1);
    }




    @Override
    protected void runMain() {
        Application.main(new String[]{});

    }
}
