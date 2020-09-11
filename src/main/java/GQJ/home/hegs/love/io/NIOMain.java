package GQJ.home.hegs.love.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
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

    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getGlobal();
        Path path = Paths.get("");
        // D:\idea-study\hegs
        logger.info(path.toAbsolutePath() + "");
        Path p = Paths.get("..");
        // D:\idea-study\hegs\..
        logger.info(p.normalize().toAbsolutePath().toString());
        nioRead();
    }

    public static void nioRead() throws IOException {
        FileOutputStream out = new FileOutputStream("C:/Users/dhht/Desktop/test-lishi/nio.sql");
        FileChannel outChannel = out.getChannel();
        CharsetEncoder charsetEncoder = StandardCharsets.UTF_8.newEncoder();

        File source = new File("C:/Users/dhht/Desktop/test-lishi/composing.SQL");
        FileInputStream in = new FileInputStream(source);
        FileChannel channel = in.getChannel();
        CharsetDecoder charsetDecoder = StandardCharsets.UTF_8.newDecoder();
        //MappedByteBuffer byteBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
        MappedByteBuffer byteBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, source.length());
        CharBuffer charBuffer = charsetDecoder.decode(byteBuffer);
        System.out.println("文件内容:" + charBuffer);
        charBuffer.clear();
        outChannel.write(charsetEncoder.encode(charBuffer));

        channel.close();
        in.close();
        outChannel.close();
        out.close();
    }
}
