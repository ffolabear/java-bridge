package bridge;

import bridge.service.Round;

import java.util.List;

public class BridgeGame {

    private long trial = 1;
    private boolean continueRound = true;
    boolean gameResult;
    private Round round;
    private List<String> answerBridge;

    public void startGame() {
        generateBridge();
        startRound();
        gameResult = false;
    }

    public void generateBridge() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        int bridgeLength;
        bridgeLength = bridgeMaker.inputBridgeLength();
        answerBridge = bridgeMaker.makeBridge(bridgeLength);
    }

    public void startRound() {
        gameResult = true;
        playRound();
        round.printFinalResult(trial);
    }

    public void playRound() {
        round = new Round(answerBridge);
        continueRound = round.compareBridgeSize();
        while (continueRound && !round.isCorrectRound()) {
            move();
        }
    }

    public void escapeRound() {
        if (round.continueRound()) {
            retry();
            continueRound = false;
        }
        if (round.isCorrectRound()) {
            continueRound = false;
        }
    }

    public void move() {
        round.userBridge.add(round.inputCommand());
        if (continueRound) {
            round.printRoundResult();
        }
        if (!round.isCorrectRound()) {
            escapeRound();
        }
    }

    public void retry() {
        gameResult = false;
        if (round.retryRound()) {
            trial += 1;
            playRound();
        }
    }

}
