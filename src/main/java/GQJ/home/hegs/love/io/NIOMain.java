package GQJ.home.hegs.love.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
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
        FileOutputStream out = new FileOutputStream("C:/Users/dhht/Desktop/test-lishi/nio.txt");
        FileChannel outChannel = out.getChannel();
        CharsetEncoder charsetEncoder = StandardCharsets.UTF_8.newEncoder();


        FileInputStream in = new FileInputStream("C:/Users/dhht/Desktop/test-lishi/output.log");
        FileChannel channel = in.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        CharsetDecoder charsetDecoder = StandardCharsets.UTF_8.newDecoder();
        while (channel.read(buffer) > 0) {
            // 这个clear很关键,不然死循环读第一次
            //channel.read(buffer);
            buffer.clear();
            CharBuffer charBuffer = charsetDecoder.decode(buffer);
            charBuffer.clear();
            outChannel.write(charsetEncoder.encode(charBuffer));

        }
        channel.close();
        in.close();
        outChannel.close();
        out.close();
    }
}
