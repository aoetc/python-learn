class Dice {
    int faceValue;

    void roll() {
        faceValue = (int) (Math.random() * 6) + 1; // 1～6
    }

    int getFaceValue() { return faceValue; }
}

class DiceGame {
    Dice dice1 = new Dice();
    Dice dice2 = new Dice();

    boolean play() {
        dice1.roll();
        dice2.roll();
        int sum = dice1.getFaceValue() + dice2.getFaceValue();
        System.out.println("骰子: " + dice1.getFaceValue() + " + "
                + dice2.getFaceValue() + " = " + sum);
        return sum == 7;
    }
}

public class Ans_DiceGame {
    public static void main(String[] args) {
        DiceGame g = new DiceGame();
        if (g.play()) {
            System.out.println("赢");
        } else {
            System.out.println("输");
        }
    }
}
