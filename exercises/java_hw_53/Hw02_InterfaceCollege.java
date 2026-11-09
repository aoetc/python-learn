/**
 * 填空2：
 * (1) void prtMsg();
 * (2) class College implements Student
 * (3) private String id; private String name;
 * (4) College(String id, String name){ this.id=id; this.name=name; }
 * (5) public void prtMsg()
 */
interface Student {
    void prtMsg();
}

class College implements Student {
    private String id;
    private String name;

    College(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void prtMsg() {
        System.out.println(id + name);
    }
}

public class Hw02_InterfaceCollege {
    public static void main(String[] args) {
        new College("002", "李四").prtMsg();
    }
}
