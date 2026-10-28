/** 补全圆：设半径 + 算面积 */
class Zuoye {
    private float r;

    public void setR(float r) { // 补充1：setter
        this.r = r;
    }

    public float circle() {
        return 3.14f * r * r;
    }
}

public class Ans_ZuoyeCircle {
    public static void main(String[] args) {
        Zuoye z = new Zuoye();
        z.setR(10); // 补充2
        System.out.println("面积: " + z.circle());
    }
}
