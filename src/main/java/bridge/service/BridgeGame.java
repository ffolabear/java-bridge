package bridge.service;

import bridge.BridgeRandomNumberGenerator;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스 -> 컨트롤러
 */
public class BridgeGame {

    private long trial = 1;
    private Round round;
    boolean gameResult;
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
        while (round.compareBridgeSize()) {
            move();
            if (round.continueRound()) {
                retry();
                break;
            }
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        round.userBridge.add(round.inputCommand());
        round.printRoundResult();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        gameResult = false;
        if (round.retryRound()) {
            trial += 1;
            playRound();
        }
    }

}
