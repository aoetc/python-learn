/** 3. 温度说明：先分成 1～4，再用 switch。 */
public class Hw03_TempSwitch {
    public static void main(String[] args) {
        int c = 30;
        int t = c < 10 ? 1 : c < 25 ? 2 : c < 35 ? 3 : 4;

        switch (t) {
            case 1 -> System.out.println(c + "℃ 有点冷。要多穿衣服。");
            case 2 -> System.out.println(c + "℃ 正合适。出去玩吧。");
            case 3 -> System.out.println(c + "℃ 有点热。");
            default -> System.out.println(c + "℃ 太热了!开空调。");
        }
    }
}
