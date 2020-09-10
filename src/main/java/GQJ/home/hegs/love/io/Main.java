package GQJ.home.hegs.love.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @Author: sh
 * @Description:
 * @Version:
 * @Date: 2020/9/9
 */
public class Main {

    static Logger logger = Logger.getGlobal();

    public static void main(String[] args) throws Exception {
        // /D:/idea-study/hegs/target/classes/
        logger.info(Main.class.getResource("/").getPath());
        // /D:/idea-study/hegs/target/classes/GQJ/home/hegs/love/io/
        logger.info(Main.class.getResource("").getPath());
        File file = new File("");
        logger.info(file.getPath());
        // D:\idea-study\hegs
        logger.info(file.getAbsolutePath());
        // D:\idea-study\hegs
        logger.info(file.getCanonicalPath());
        File f = new File(File.separator + "2020" + File.separator + "0909");
        logger.info("f.exists():" + f.exists());
        // D:\2020\0909
        logger.info(f.getAbsolutePath());
        // 判断该File对象是否是一个已存在的磁盘目录
        logger.info("f.isDirectory():" + f.isDirectory());
        // true
        logger.info(f.mkdirs() + "");
        File fi = new File(File.separator + "2020" + File.separator + "0909" + File.separator + "za.jpg");
        logger.info(fi.getAbsolutePath());
        logger.info("fi.exists():" + fi.exists());
        // 判断该File对象是否是一个已存在磁盘的文件
        logger.info("fi.isFile():" + fi.isFile());
        logger.info(fi.createNewFile() + "");

        File dir = new File("D:/dingding");
        // 子目录名与文件名
        String[] files = dir.list();
        Arrays.asList(files).forEach(bean -> {
            logger.info("dir.list()-" + bean);
        });
        // 子目录名与文件名,FilenameFilter()过滤器
        File[] fs = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".exe");
            }
        });
        Arrays.asList(fs).forEach(bean -> {
            logger.info("dir.listFiles()-" + bean.getName());
        });

        loopDir("C:/Users/dhht/Desktop/test-lishi");

        readZip("C:/Users/dhht/Desktop/test-lishi/xx.zip");

        loadProper();


    }

    // 递归遍历目录文件
    public static void loopDir(String dir) throws Exception {
        File fileDir = new File(dir);
        if (!fileDir.exists()) {
            return;
        }
        File[] fileArray = fileDir.listFiles();
        if (fileArray.length > 0) {
            for (File file : fileArray) {
                if (file.isDirectory()) {
                    logger.info(file.getParent() + File.separator);
                    loopDir(file.getCanonicalPath());
                }
                if (file.isFile()) {
                    logger.info(file.getParent() + File.separator + file.getName());
                }
            }
        }
    }

    public static void readStream(String file) throws IOException {
        File tar = new File(file);
        if (!tar.exists()) {
            return;
        }
        // 编译器可自动关闭fileInputStream（需实现java.lang.AutoCloseable接口）
        try (InputStream inputStream = new FileInputStream(tar)) {
            // 每次读取到缓冲区，效率较高
            byte[] buffer = new byte[1024];
            int flag = 0;
            while ((flag = inputStream.read(buffer)) != -1) {
                logger.info(flag + "");
            }
        }
    }

    public static void readZip(String file) throws IOException {
        File tar = new File(file);
        if (!tar.exists()) {
            return;
        }
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(tar))) {
            ZipEntry entry;
            //byte[] buffer = new byte[1024];
            while ((entry = zipInputStream.getNextEntry()) != null) {
                if (!entry.isDirectory()) {
                    //Reader reader = new InputStreamReader(zipInputStream);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(zipInputStream, StandardCharsets.UTF_8));
                    String lineCon = null;
                    while ((lineCon = bufferedReader.readLine()) != null) {
                        logger.info(entry.getName());
                        logger.info("行内容:" + lineCon);
                    }

                }
            }
        }
    }

    public static void loadProper() throws IOException {
        InputStream in = Main.class.getResourceAsStream("/application.properties");
        Properties properties = new Properties();
        properties.load(in);
        logger.info(properties.getProperty("server.port"));

    }

}
