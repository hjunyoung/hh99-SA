package OOPBaseballNumber;

import java.util.ArrayList;
public class GenerateRandomAnswer implements AnswerGenerator{
    @Override
    public ArrayList<Integer> generateAnswer(int length) {
        ArrayList<Integer> answers = new ArrayList<Integer>();
        while (answers.size() < length) {
            int value = (int) (Math.random() * 10);
            if (answers.contains(value)) {  // 이미 값이 있는 경우  중복처리
                continue; // 넘어가
            }
            answers.add(value); // 값이 없는 경우 array에 추가해준
        }
        return answers;
    }
}
