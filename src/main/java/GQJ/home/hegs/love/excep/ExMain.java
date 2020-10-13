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
        ClassLoader classLoader = ExMain.class.getClassLoader();
        //jdk9 jdk11下结果
        //jdk.internal.loader.ClassLoaders$AppClassLoader@2437c6dc
        //jdk.internal.loader.ClassLoaders$PlatformClassLoader@61a485d2
        //null
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());
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
