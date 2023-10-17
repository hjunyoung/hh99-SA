import java.util.ArrayList;
import java.util.Scanner;

public class baseballNumber {
    public static void main(String[] args) {
        ArrayList<Integer> answers = new ArrayList<Integer>();

        // while (answer.length == 3)
        while (answers.size() < 3) {
            int value = (int) (Math.random() * 10);
            if (answers.contains(value)) {  // 이미 값이 있는 경우  중복처리
                continue; // 넘어가
            }
            answers.add(value); // 값이 없는 경우 array에 추가해준
        }

        //  사용자 input 받기 - 3번 맞출 때가지 loop
        Scanner sc = new Scanner(System.in);

        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");
        int tryNum = 0;
        int count = 0;
        while(count < 3) {
            tryNum++;
            System.out.print(String.format("%d번째 시도 : ", tryNum ));
            int input = sc.nextInt();

            // 사용자 input -> Array로 변환
            ArrayList<Integer> userInputs = new ArrayList<Integer>();
            int hundred = input / 100;
            int ten = (input - (hundred * 100)) / 10;
            int one = input % 10;
            userInputs.add(hundred);
            userInputs.add(ten);
            userInputs.add(one);

            // input check 하고 맞으면 count++
            int strike = 0;
            int ball = 0;
            for (int i = 0; i < userInputs.size(); i++) {
                int current = userInputs.get(i);
                // 위치 같은 경우 strike
                if (answers.contains(current)) {
                    ball++;
                }
                if (userInputs.get(i).equals(answers.get(i))) {
                    strike++;
                    ball--;
                }
            }
            System.out.println(String.format("%dB%dS", ball, strike));

            if (strike == 3){
                System.out.println(String.format(String.format("%d번만에 맞히셨습니다.", tryNum )));
                System.out.println("게임을 종료합니다.");
                break;
            }
        }
    }
}