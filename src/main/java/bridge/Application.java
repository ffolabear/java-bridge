package bridge;

import bridge.service.BridgeGame;
import bridge.util.OutputView;
import bridge.view.Messages;

public class Application {

    public static void main(String[] args) {
        OutputView.printSystemMessage(Messages.GAME_START_MESSAGE);
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.startGame();
    }
}
