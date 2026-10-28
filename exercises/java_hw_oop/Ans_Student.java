class StudentOOP {
    String xm, xh, xb;

    StudentOOP() {}

    StudentOOP(String xm, String xh, String xb) {
        this.xm = xm;
        this.xh = xh;
        this.xb = xb;
    }

    void setXm(String xm) { this.xm = xm; }
    String getXm() { return xm; }
    void setXh(String xh) { this.xh = xh; }
    String getXh() { return xh; }
    void setXb(String xb) { this.xb = xb; }
    String getXb() { return xb; }

    void print() {
        System.out.println("姓名:" + xm + " 学号:" + xh + " 性别:" + xb);
    }

    public String toString() {
        return "Student[xm=" + xm + ",xh=" + xh + ",xb=" + xb + "]";
    }
}

public class Ans_Student {
    public static void main(String[] args) {
        StudentOOP s = new StudentOOP("李宏", "2026001", "男");
        s.print();
        System.out.println(s.toString());
    }
}
