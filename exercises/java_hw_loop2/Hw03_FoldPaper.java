/** 3. 纸厚 X 毫米，对折到 ≥ 8844.43 米。次数？这里 X 取常见 0.1 毫米，可改。 */
public class Hw03_FoldPaper {
    public static void main(String[] args) {
        double xMm = 0.1;                 // 纸厚（毫米），题目写 X，可按老师给的改
        double heightM = 8844.43;         // 珠峰高度（米）
        double heightMm = heightM * 1000; // 统一成毫米

        double thick = xMm;
        int times = 0;
        while (thick < heightMm) {
            thick = thick * 2;            // 对折一次厚度翻倍
            times++;
        }
        System.out.println("纸厚 " + xMm + " 毫米，对折 " + times + " 次后厚度达到珠峰高度");
        System.out.println("最终厚度约 " + (thick / 1000) + " 米");
    }
}
