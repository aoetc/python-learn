/**
 * 题4：商场库存清单（按作业截图数据）
 *
 * 目标输出类似：
 * ----------商品库存清单----------
 * 品牌型号        尺寸    价格      配置                      库存数量
 * MacBookAir     13.3    6988.8    I5处理器4G内存128G固态硬盘    3
 * ThinkPad450    14.0    7988.8    I5处理器4G内存128G固态硬盘    2
 * ------------------------------
 * 总库存数量：5
 * 库存商品总金额：36944.0     （或 36944，6988.8*3 + 7988.8*2）
 *
 * 做法：每种商品用一组变量存 5 项信息，println 打印；
 *       总库存 = 3+2；总金额 = 单价1*数量1 + 单价2*数量2
 * 本题按截图写死数据即可，一般不用 Scanner。
 */
public class P04_Inventory {
    public static void main(String[] args) {
        String model1="MacBookAir";
        double size1=13.3;
        double price1=6988.8;
        String config1="I5处理器4G内存128G固态硬盘";
        int num1=3;
        
        String model2="ThinkPad450";
        double size2=14.0;
        double price2=7988.8;
        String config2=config1;
        int num2=2;

        int totalnum=num1+num2;
        double totalprice=num1*price1+num2*price2;
        System.out.println("--------商品库存清单---------");
        System.out.println("品牌型号\t尺寸\t金额\t价格\t配置\t库存");
        System.out.println(model1+'\t'+size1+'\t'+price1+'\t'+config1+'\t'+num1);
        System.out.println(model2+'\t'+size2+'\t'+price2+'\t'+config2+'\t'+num2);
        System.out.println("---------------------------");
        System.out.println("库存商品总数量："+totalnum);
        System.out.println("库存商品总金额："+totalprice);
    }
}
