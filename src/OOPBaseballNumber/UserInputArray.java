package OOPBaseballNumber;

import java.util.ArrayList;


public class UserInputArray implements GetArray {
    @Override
    public ArrayList<Integer> getUserInputArray(String input) {

        ArrayList<Integer> userInputs = new ArrayList<>();
        for (char c: input.toCharArray()) {
            userInputs.add(c -'0');
        }
        return userInputs;
    }

}
