package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.OutputView;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스 -> 컨트롤러
 *
 * *********** InputView, OutView 사용 금지 ***********
 * 패키지는 변경할 수 있다.
 * 필드(인스턴스 변수)를 추가할 수 있다.
 * 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 게임 진행을 위해 필요한 메서드를 추가 하거나 변경할 수 있다.
 */
public class BridgeGame {

    int bridgeLength;
    int currentPosition;
    List<String> bridge;


    public BridgeGame() {
        startGame();
    }

    public void startGame(){
            currentPosition = 0;
            generateBridge();
    }

    public void generateBridge() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        bridgeLength = bridgeMaker.inputBridgeLength();
        bridge = bridgeMaker.makeBridge(bridgeLength);
        System.out.println(bridge);
        OutputView outputView = new OutputView();
        outputView.printMap(bridge);
    }


    public void playGame() {
        currentPosition = 0;
        while (currentPosition < bridgeLength) {

            currentPosition++;
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(String command) {

        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String command) {
        if (command.equals("R")) {
            return true;
        }
        return false;
    }
}
