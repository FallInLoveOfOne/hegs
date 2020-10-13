package GQJ.home.hegs.love.excep;

/**
 * @Author: sh
 * @Description:
 * @Version:
 * @Date: 2020/10/13
 */
public class ExMain {

    public static void main(String[] args) {
        System.out.println(cal());
    }

    public static int cal() {
        int i = 0;
        try {
            i = 1000;
            int n = i / 0;
            return i;
        } catch (Exception e) {
            i++;
            // 返回的i值会暂存,finally 改变i的值不影响
            return i;
        } finally {
            i--;
            System.out.println("finally:i:" + i);
            // finally return优先catch return,避免在finally中return
            //return i;
        }
    }
}
