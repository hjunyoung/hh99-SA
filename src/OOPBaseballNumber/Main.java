package OOPBaseballNumber;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        Game baseBallNumberGame =  new BaseballNumber(4, new UserInputArray(), new GenerateRandomAnswer());
        System.out.println(baseBallNumberGame.title);
        baseBallNumberGame.start();
    }
}