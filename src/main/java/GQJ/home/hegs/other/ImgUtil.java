package GQJ.home.hegs.other;

import net.coobird.thumbnailator.Thumbnails;

import java.io.File;

/**
 * @Author: sh
 * @Description: https://www.xuebuyuan.com/3229489.html
 * @Version:
 * @Date: 2020/11/10
 */
public class ImgUtil {

    public static void main(String[] args) throws Exception{

        //Thumbnails.of(new File("C:\\Users\\dhht\\Desktop\\press\\222.png")).size(400,500).toFile(new File("C:\\Users\\dhht\\Desktop\\press\\tar\\3.png"));
        //Thumbnails.of("C:\\Users\\dhht\\Desktop\\press\\222.png")
        Thumbnails.of("C:\\Users\\dhht\\Desktop\\press\\222.bmp")
                .scale(1f)
                //.outputQuality(0.25f)
                .outputQuality(0.25f)
                .outputFormat("jpg")
                .toFile("C:\\Users\\dhht\\Desktop\\press\\tar\\demo");
    }
}
