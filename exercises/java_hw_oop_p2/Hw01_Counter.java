/*
 * 计数器类 Computer（或叫 Counter）
 * 属性：counterValue
 * 方法：increment() +1；decrement() -1；reset() 清零
 * main 里测一下
 */
public class Hw01_Counter {
    public static void main(String[] args) {
        Computer c = new Computer();
        c.increment();
        c.increment();
        System.out.println("当前值：" + c.counterValue); // 2
        c.decrement();
        System.out.println("当前值：" + c.counterValue); // 1
        c.reset();
        System.out.println("当前值：" + c.counterValue); // 0
    }
}

class Computer {
    int counterValue = 0;

    void increment() {
        counterValue++;
    }

    void decrement() {
        counterValue--;
    }

    void reset() {
        counterValue = 0;
    }
}
