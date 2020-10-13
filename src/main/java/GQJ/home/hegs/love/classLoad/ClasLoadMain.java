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
    }
}
