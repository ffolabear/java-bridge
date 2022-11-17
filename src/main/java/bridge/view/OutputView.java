package bridge.view;

import bridge.view.Messages;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 * <p>
 * 패키지는 변경할 수 있다.
 * 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 값 출력을 위해 필요한 메서드를 추가할 수 있다.
 */
public class OutputView {


    StringBuilder upperBridge;
    StringBuilder lowerBridge;
    private List<String> userBridge;

    public OutputView() {
        upperBridge = new StringBuilder();
        lowerBridge = new StringBuilder();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> userBridge) {
        this.userBridge = userBridge;
        createBridgeMap();
        System.out.println(upperBridge);
        System.out.println(lowerBridge);
    }

    private void createBridgeMap() {
        addHead();
        for (String command : userBridge) {
            setLevel(command).append("O");
            addBody();
        }
        addTail();
    }


    private StringBuilder setLevel(String command) {
        if (command.equals("U")) {
            lowerBridge.append(" ");
            return upperBridge;
        }
        upperBridge.append(" ");
        return lowerBridge;
    }

    private void addHead() {
        upperBridge.append(Bridge.HEAD.getPiece());
        lowerBridge.append(Bridge.HEAD.getPiece());
    }

    private void addBody() {
        upperBridge.append(Bridge.BOARD.getPiece());
        lowerBridge.append(Bridge.BOARD.getPiece());
    }

    private void addTail() {
        upperBridge.append(Bridge.TAIL.getPiece());
        lowerBridge.append(Bridge.TAIL.getPiece());
    }

    private String setEnd(int space) {
        if (space == 0) {
            return Bridge.HEAD.getPiece();
        }
        return Bridge.TAIL.getPiece();
    }



    private void printUpperMap() {

    }

    private void printLowerMap() {

    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printSystemMessage(Messages messages) {
        System.out.println(messages.getMessage());
    }
}
