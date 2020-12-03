package GQJ.home.hegs.love.classLoad;

import sun.misc.Launcher;

import java.net.URL;
import java.util.Arrays;

/**
 * @Author: sh
 * @Description:
 * @Version:
 * @Date: 2020/10/13
 */
public class ClasLoadMain {
    public static void main(String[] args) {
        // 获取BootstrapClassLoader类加载器加载的jar
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        Arrays.asList(urLs).forEach(val -> {
            System.out.println(val.toExternalForm());
        });
        // 栈帧中的局部变量表与操作栈
        int i = 1;
        // i先入操作栈，然后在局部变量上+1,栈顶未+1的值赋给a
        int a = i++;
        // 1
        System.out.println("a:" + a);
        System.out.println("i:" + i);
        int n = 1;
        // n先在局部变量表+1，然后入操作栈,栈顶+1的值赋给b
        int b = ++n;
        // 2
        System.out.println("b:" + b);
        System.out.println("n:" + n);
    }
}
