package OOPBaseballNumber;

import java.util.ArrayList;
import java.util.Scanner;


public class BaseballNumber implements Game{

    private final Scanner sc = new Scanner(System.in);
    GetArray userInputArray;
    private final AnswerGenerator answerGenerator;
    private ArrayList<Integer> answers;
    private int length;

    public BaseballNumber(int length, GetArray userInputArray, AnswerGenerator answerGenerator ) {
        this.length = length;
        this.userInputArray = userInputArray;
        this.answerGenerator = answerGenerator;
    }

    @Override
    public  void start() {
        // 컴퓨터 정답 만들기
        answers = answerGenerator.generateAnswer(length);

        System.out.println(answers); //  test 용도

        // user input 받기
        runGame(length);
    }

    private void runGame(int length) {
        System.out.printf("컴퓨터가 %d자리 숫자를 생성하였습니다. 답을 맞춰보세요!%n", length);
        int tryNum = 0;
        while(true) {

            tryNum++;
            System.out.print(String.format("%d번째 시도 : ", tryNum ));
            String input = sc.next();

            ArrayList<Integer> userInputs = userInputArray.getUserInputArray(input);

            // input check 하고 맞으면 count++
            boolean isCorrect = checkAnswer(userInputs, tryNum);
            if (isCorrect) {
                break;
            }
        }
    }

    private boolean checkAnswer(ArrayList<Integer> userInputs, int tryNum) {
        // input check 하고 맞으면 count++
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < length; i++) {

            int current = userInputs.get(i);
            // 위치 같은 경우 strike
            if (userInputs.get(i).equals(answers.get(i))) {
                strike++;
            } else if (answers.contains(current)) {
                ball++;
            }
        }
        System.out.printf("%dB%dS%n", ball, strike);

        if (strike == length){
            System.out.printf((String.format("%d번만에 맞히셨습니다.", tryNum)) + "%n");
            System.out.println("게임을 종료합니다.");
            return true;
        }
        return false;
    }
}