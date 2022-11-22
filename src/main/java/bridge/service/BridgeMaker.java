package bridge.service;

import bridge.BridgeNumberGenerator;
import bridge.constant.GameCommand;
import bridge.util.InputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public int inputBridgeLength() {
        InputView inputView = new InputView();
        String length = inputView.readBridgeSize();
        inputView.validateEmptyInput(length);
        inputView.validateBridgeLength();
        return inputView.convertInput(length);
    }

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
