/**
 * 填空1：
 * (1) public abstract void printMsg();
 * (2) class DefaultTest extends AbstractTest
 * (3) DefaultTest(String name, String id, int score){ this.name=name; this.id=id; this.score=score; }
 * (4) DefaultTest(String name, String id){ this(name, id, 0); }
 * (5) public void printMsg(){ System.out.println(name + " " + score); }
 */
abstract class AbstractTest {
    public abstract void printMsg();
}

class DefaultTest extends AbstractTest {
    String name;
    String id;
    int score;

    DefaultTest(String name, String id, int score) {
        this.name = name;
        this.id = id;
        this.score = score;
    }

    DefaultTest(String name, String id) {
        this(name, id, 0);
    }

    public void printMsg() {
        System.out.println(name + " " + score);
    }
}

public class Hw01_AbstractTest {
    public static void main(String[] args) {
        new DefaultTest("张三", "001", 90).printMsg();
    }
}
