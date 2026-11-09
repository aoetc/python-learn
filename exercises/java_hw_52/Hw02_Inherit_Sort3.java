/** 简答2：方法的继承 —— 子类调父类 sort() */
class Sort3 {
    double max1, max2, max3;

    Sort3() {
        max1 = max2 = max3 = -1;
    }

    void sort() {
        double s;
        if (max1 < max2) { s = max1; max1 = max2; max2 = s; }
        if (max1 < max3) { s = max1; max1 = max3; max3 = s; }
        if (max2 < max3) { s = max2; max2 = max3; max3 = s; }
    }
}

class sub_Sort3 extends Sort3 {
    void subsort(double i, double j, double k) {
        max1 = i;
        max2 = j;
        max3 = k;
        sort();
    }
}

public class Hw02_Inherit_Sort3 {
    public static void main(String[] args) {
        sub_Sort3 m1 = new sub_Sort3();
        m1.subsort(100, 200, 300);
        System.out.println("三个数从大到小为：" + m1.max1 + "," + m1.max2 + "," + m1.max3);
        // 输出：300.0,200.0,100.0
    }
}
