package racing;

import java.util.Iterator;

public class ResultView {
    private static final String EXECUTION_RESULT = "실행 결과";
    private static final String CAR_SYMBOL = "-";
    private static final String CAR_NAME_SEPARATOR = " : ";
    private static final String WINNER_SEPARATOR = ", ";
    private static final String RACING_END_MESSAGE = "가 최종 우승했습니다.";


    public static void printResultMessage() {
        System.out.println(EXECUTION_RESULT);
    }

    public static void printRacingStatus(Cars cars) {
        cars.getCars().forEach(ResultView::printCarStatus);
    }

    public static void printEndGame(RaceWinner raceWinner) {
        printLineBreak();
        printRacingWinner(raceWinner);
        printRacingEndMessage();
    }

    public static void printCarStatus(Car car) {
        printCarName(car);
        for (int i = 0; i < car.getPosition(); i++) {
            printCarSymbol(car);
        }
        printLineBreak();
    }

    public static void printCarName(Car car) {
        if (car.getPosition() > 0) {
            System.out.print(car.carName() + CAR_NAME_SEPARATOR);
        }
    }

    public static void printCarSymbol(Car car) {
        if (car.getPosition() > 0) {
            System.out.print(CAR_SYMBOL);
        }
    }

    public static void printLineBreak() {
        System.out.println();
    }

    public static void printRacingWinner(RaceWinner raceWinner) {
        Iterator<Car> carIterator = raceWinner.getWinners().iterator();
        while (carIterator.hasNext()) {
            System.out.print(carIterator.next().carName());
            if (carIterator.hasNext()) {
                System.out.print(WINNER_SEPARATOR);
            }
        }
    }

    public static void printRacingEndMessage() {
        System.out.println(RACING_END_MESSAGE);
    }
}
