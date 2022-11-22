package bridge;

import bridge.view.Messages;

public class Application {

    public static void main(String[] args) {
        try {
            OutputView.printSystemMessage(Messages.GAME_START_MESSAGE);
            BridgeGame bridgeGame = new BridgeGame();
            bridgeGame.startGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
