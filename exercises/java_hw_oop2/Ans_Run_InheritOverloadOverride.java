/** 卷面「运行理解」四题：隐藏 / 继承调用 / 重载 / 覆盖 —— 可分别体会输出 */
class Sum_3 {
    int sum, num1, num2;
    static int num3;

    Sum_3() {
        num1 = num2 = num3 = sum = 0;
    }
}

class Sub_sum3 extends Sum_3 {
    int sum, num1, num2;
    static int num3;

    void sum(int i, int j, int k) {
        num1 = i;
        num2 = j;
        num3 = k;
        sum = num1 + num2 + num3;
    }
}

class Sort3 {
    double max1, max2, max3;

    Sort3() { max1 = max2 = max3 = -1; }

    void sort() {
        double s;
        if (max1 < max2) { s = max1; max1 = max2; max2 = s; }
        if (max1 < max3) { s = max1; max1 = max3; max3 = s; }
        if (max2 < max3) { s = max2; max2 = max3; max3 = s; }
    }
}

class sub_Sort3 extends Sort3 {
    void subsort(double i, double j, double k) {
        max1 = i; max2 = j; max3 = k;
        sort(); // 继承来的方法
    }
}

class Sort2or3 {
    double max1, max2, max3;

    Sort2or3() { max1 = max2 = max3 = -1; }

    void sort(double i, double j) {
        max1 = i; max2 = j;
        if (max1 < max2) { double s = max1; max1 = max2; max2 = s; }
    }

    void sort(double i, double j, double k) {
        max1 = i; max2 = j; max3 = k;
        double s;
        if (max1 < max2) { s = max1; max1 = max2; max2 = s; }
        if (max1 < max3) { s = max1; max1 = max3; max3 = s; }
        if (max2 < max3) { s = max2; max2 = max3; max3 = s; }
    }
}

class sort_Demo {
    int i, j, k, swap;

    void sort(int t1, int[] t2) {
        for (i = 0; i < t1 - 1; i++) {
            k = i;
            for (j = i + 1; j < t1; j++)
                if (t2[j] < t2[k]) k = j;
            if (k != i) {
                swap = t2[i]; t2[i] = t2[k]; t2[k] = swap;
            }
        }
    }
}

class sub_sort_Demo extends sort_Demo {
    void sort(int t1, int[] t2) {
        for (i = 0; i < t1 - 1; i++) {
            k = i;
            for (j = i + 1; j < t1; j++)
                if (t2[j] > t2[k]) k = j;
            if (k != i) {
                swap = t2[i]; t2[i] = t2[k]; t2[k] = swap;
            }
        }
    }
}

public class Ans_Run_InheritOverloadOverride {
    public static void main(String[] args) {
        Sub_sum3 m1 = new Sub_sum3();
        m1.sum(100, 200, 300);
        System.out.println("隐藏: sum=" + m1.num1 + "+" + m1.num2 + "+" + m1.num3 + "=" + m1.sum);

        sub_Sort3 s = new sub_Sort3();
        s.subsort(100, 200, 300);
        System.out.println("继承调用: " + s.max1 + "," + s.max2 + "," + s.max3);

        Sort2or3 o = new Sort2or3();
        o.sort(100, 200);
        System.out.println("重载2: " + o.max1 + "," + o.max2);
        o.sort(50, 150, 100);
        System.out.println("重载3: " + o.max1 + "," + o.max2 + "," + o.max3);

        int[] a = {34, 12, 8, 67, 88, 23, 98, 101, 119, 56};
        new sort_Demo().sort(a.length, a);
        System.out.print("升序:");
        for (int v : a) System.out.print(" " + v);
        new sub_sort_Demo().sort(a.length, a);
        System.out.print("\n降序:");
        for (int v : a) System.out.print(" " + v);
        System.out.println();
    }
}
