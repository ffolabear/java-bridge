package bridge;

import bridge.service.BridgeFormat;
import bridge.validation.Validation;
import bridge.view.Messages;

import java.util.List;

public class OutputView {

    public static void printMap(List<List<String>> resultBridge) {
        BridgeFormat bridgeFormat = new BridgeFormat(resultBridge);
        System.out.println(bridgeFormat.formattedBridge());
    }

    public static void printResult(List<List<String>> resultBridge, String gameResult, long trial) {
        Validation validation = new Validation();
        validation.validateTrialNumber(trial);
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

    public static void printGameTrialMessage(Messages messages, long trial) {
        System.out.printf((messages.getMessage()) + "%n", trial);
    }
}
