/*
 * ========== 题干 Ex01 ==========
 * 给定整数 day（表示星期几）：
 *   1 → 打印「星期一」
 *   2 → 打印「星期二」
 *   3 → 打印「星期三」
 *   4 → 打印「星期四」
 *   5 → 打印「星期五」
 *   6 → 打印「星期六」
 *   7 → 打印「星期日」
 *   其它 → 打印「无效日期」
 *
 * 要求：用 switch 完成（箭头写法 case 1 -> 或传统 case+break 均可）
 * 自测：把下面的 day 改成 3、7、9 各运行一次
 * ==============================
 */

public class Ex01Switch {
    public static void main(String[] args) {
        System.out.println("【Ex01】用 switch 根据 day 打印星期（1~7）");

        int day = 2; // 改这里自测：3 / 7 / 9
        String[] names={"","一","二","三","四","五","六","七"};
        if(day>=1 && day<=7){
            System.out.println(names[day]);
        }else{
            System.out.println("无效日期");
        }


    }
}
/**
 * switch(day):
 * case 1 ->System.out.println("星期一")*/