package bridge.service;

import bridge.BridgeRandomNumberGenerator;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스 -> 컨트롤러
 * <p>
 * *********** InputView, OutView 사용 금지 ***********
 * 패키지는 변경할 수 있다.
 * 필드(인스턴스 변수)를 추가할 수 있다.
 * 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 게임 진행을 위해 필요한 메서드를 추가 하거나 변경할 수 있다.
 */
public class BridgeGame {

    private long trial = 1;
    boolean gameResult;
    private List<String> answerBridge;
    private Round round;

    public BridgeGame() {
        startGame();
    }

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
        while (round.userBridge.size() < answerBridge.size()) {
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
        round.printRoundResult2();
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
