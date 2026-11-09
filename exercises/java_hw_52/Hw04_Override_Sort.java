/** 简答4：方法覆盖 —— 父类升序，子类降序 */
class sort_Demo {
    int i, j, k, swap;

    void sort(int t1, int[] t2) {
        for (i = 0; i < t1 - 1; i++) {
            k = i;
            for (j = i + 1; j < t1; j++)
                if (t2[j] < t2[k]) k = j;
            if (k != i) {
                swap = t2[i];
                t2[i] = t2[k];
                t2[k] = swap;
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
                swap = t2[i];
                t2[i] = t2[k];
                t2[k] = swap;
            }
        }
    }
}

public class Hw04_Override_Sort {
    public static void main(String[] args) {
        int[] a = {34, 12, 8, 67, 88, 23, 98, 101, 119, 56};
        System.out.print("排序前：");
        for (int v : a) System.out.print(" " + v);

        new sort_Demo().sort(a.length, a);
        System.out.print("\n升序：");
        for (int v : a) System.out.print(" " + v);

        new sub_sort_Demo().sort(a.length, a);
        System.out.print("\n降序：");
        for (int v : a) System.out.print(" " + v);
        System.out.println();
    }
}
