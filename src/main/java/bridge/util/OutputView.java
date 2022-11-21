package bridge.util;

import bridge.view.Messages;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 * <p>
 * 패키지는 변경할 수 있다.
 * 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 값 출력을 위해 필요한 메서드를 추가할 수 있다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<List<String>> resultBridge) {
        BridgeFormat bridgeFormat = new BridgeFormat(resultBridge);
        System.out.println(bridgeFormat.formattedBridge());
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(List<List<String>> resultBridge, String gameResult, int trial) {
        printSystemMessage(Messages.GAME_RESULT_TITLE);
        printMap(resultBridge);
        printGameResultMessage(Messages.GAME_RESULT_MESSAGE, gameResult);
        printGameTrialMessage(Messages.GAME_TRIAL_MESSAGE, trial);
    }

    public static void printSystemMessage(Messages messages) {
        System.out.println(messages.getMessage());
    }

    public static void printGameResultMessage(Messages messages, String gameResult) {
        System.out.printf((messages.getMessage()) + "%n", gameResult);
    }

    public static void printGameTrialMessage(Messages messages, int trial) {
        System.out.printf((messages.getMessage()) + "%n", trial);
    }
}
