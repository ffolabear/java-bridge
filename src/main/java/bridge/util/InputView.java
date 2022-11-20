package bridge.util;

import bridge.validation.InputValidation;
import bridge.view.Messages;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * <p>
 * 패키지는 변경할 수 있다.
 * 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
 * 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.
 */
public class InputView {

    OutputView outputView;
    InputValidation inputValidation;
    String bridgeLength;
    String command;
    String retry;

    public InputView() {
        outputView = new OutputView();
        inputValidation = new InputValidation();
    }

    public String getCommand() {
        return command;
    }

    public void validateBridgeLength() {
        inputValidation.validateBridgeLength(bridgeLength);
    }

    public void validateGameCommand() {
        inputValidation.validateGameCommand(command);
    }

    public void validateRetryCommand() {
        inputValidation.validateRetryCommand(retry);
    }

    /**
     * 다리의 길이를 입력받는다.
     * 검증메서드 : isLengthDigit -> convertInput -> isLengthValidRange
     */
    public String readBridgeSize() {
        outputView.printSystemMessage(Messages.INPUT_BRIDGE_LENGTH_MESSAGE);
        bridgeLength = Console.readLine();
        return bridgeLength;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     * 검증메서드 : isValidGameCommand
     */
    public String readMoving() {
        outputView.printSystemMessage(Messages.INPUT_GAME_COMMAND_MESSAGE);
        command = Console.readLine();
        return command;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     * 검증메서드 : isValidReplayCommand
     */
    public String readGameCommand() {
        outputView.printSystemMessage(Messages.GAME_RETRY_MESSAGE);
        retry = Console.readLine();
        return retry;
    }


    /*
        추가 구현 코드
     */
    public int convertInput(String input) {
        return Integer.parseInt(input);
    }

}
