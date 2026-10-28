/** 4. 成绩等级。测试 98、84、77、65、40。 */
public class Hw04_GradeSwitch {
    public static void main(String[] args) {
        int[] grades = {98, 84, 77, 65, 40};
        for (int grade : grades) {
            int k = grade / 10;
            String level;
            switch (k) {
                case 10, 9 -> level = "A（90分以上）";
                case 8 -> level = "B（80分以上）";
                case 7 -> level = "C（70分以上）";
                case 6 -> level = "D（60分以上）";
                default -> level = "E（60分以下）";
            }
            System.out.println(grade + " → " + level);
        }
    }
}
