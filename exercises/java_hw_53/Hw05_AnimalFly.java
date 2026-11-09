/** 程序设计5：Animal + Flyable + Glede + Pigeon */
class Animal {
    private String type;

    Animal(String type) {
        this.type = type;
    }

    public String toString() {
        return "动物类型：" + type;
    }

    public void cry() {
        System.out.println(type + "发出叫声");
    }
}

interface Flyable {
    double flySpeed();
}

class Glede extends Animal implements Flyable {
    Glede() {
        super("老鹰");
    }

    public void cry() {
        System.out.println("老鹰：尖叫");
    }

    public double flySpeed() {
        return 160;
    }
}

class Pigeon extends Animal implements Flyable {
    Pigeon() {
        super("鸽子");
    }

    public void cry() {
        System.out.println("鸽子：咕咕");
    }

    public double flySpeed() {
        return 80;
    }
}

public class Hw05_AnimalFly {
    public static void main(String[] args) {
        Glede g = new Glede();
        Pigeon p = new Pigeon();
        System.out.println(g);
        g.cry();
        System.out.println("最大飞行速度：" + g.flySpeed());
        System.out.println(p);
        p.cry();
        System.out.println("最大飞行速度：" + p.flySpeed());
    }
}
