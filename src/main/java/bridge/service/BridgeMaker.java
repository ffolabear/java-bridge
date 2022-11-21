package bridge.service;

import bridge.BridgeNumberGenerator;
import bridge.constant.GameCommand;
import bridge.util.InputView;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public int inputBridgeLength() {
        InputView inputView = new InputView();
        String length = inputView.readBridgeSize();
        inputView.validateBridgeLength();
        return inputView.convertInput(length);
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     * <p>
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bridge.add(generateSpace(bridgeNumberGenerator.generate()));
        }
        return bridge;
    }

    private String generateSpace(int randomNumber) {
        if (randomNumber == 1) {
            return GameCommand.UP.getCommand();
        }
        return GameCommand.DOWN.getCommand();
    }
}
