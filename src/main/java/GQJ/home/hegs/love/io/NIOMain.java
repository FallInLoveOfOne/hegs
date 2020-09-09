package GQJ.home.hegs.love.io;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

/**
 * @Author: sh
 * @Description:
 * @Version:
 * @Date: 2020/9/9
 */
public class NIOMain {

    public static void main(String[] args) {
        Logger logger = Logger.getGlobal();
        Path path = Paths.get("");
        // D:\idea-study\hegs
        logger.info(path.toAbsolutePath() + "");
        Path p = Paths.get("..");
        // D:\idea-study\hegs\..
        logger.info(p.normalize().toAbsolutePath().toString());
    }
}
