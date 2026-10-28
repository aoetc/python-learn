class PointM {
    int x, y;

    PointM() { x = 0; y = 0; }

    void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    void print() {
        System.out.println("(" + x + "," + y + ")");
    }
}

public class Ans_PointMove {
    public static void main(String[] args) {
        PointM p = new PointM();
        p.print();
        p.move(3, 4);
        p.print();
    }
}
