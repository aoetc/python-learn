/** 梯形：原题 (upper+lower)high/2 缺乘号，已改为 * */
class Tixing {
    double upper, lower, high;

    public Tixing() {}

    public Tixing(double upper, double lower, double high) {
        this.upper = upper;
        this.lower = lower;
        this.high = high;
    }

    double getArea() {
        return (upper + lower) * high / 2;
    }

    public double getUpper() { return upper; }
    public void setUpper(double upper) { this.upper = upper; }
    public double getLower() { return lower; }
    public void setLower(double lower) { this.lower = lower; }
    public double getHigh() { return high; }
    public void setHigh(double high) { this.high = high; }

    public String toString() {
        return "Tixing [upper=" + upper + ", lower=" + lower + ", high=" + high + "]";
    }
}

public class Ans_Tixing {
    public static void main(String[] args) {
        Tixing t1 = new Tixing(10, 20, 10);
        System.out.println(t1.upper + " " + t1.lower + " " + t1.high);
        System.out.println(t1.getArea());
        System.out.println(t1.toString());
        t1.setHigh(100);
        System.out.println(t1.toString());

        Tixing t2 = new Tixing(20, 40, 20);
        System.out.println(t2.toString());
        t2 = t1; // 引用赋值：t2 和 t1 指向同一对象
        System.out.println(t2.toString());
        System.out.println(t1.toString());
        t1.setHigh(50);
        System.out.println(t2.toString()); // 一起变
        System.out.println(t1.toString());

        int i = 10;
        int j = i;
        System.out.println(i + " " + j);
        i = 20;
        System.out.println(i + " " + j); // j 仍是 10：基本类型复制值
    }
}
