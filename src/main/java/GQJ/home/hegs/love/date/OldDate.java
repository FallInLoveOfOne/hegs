package GQJ.home.hegs.love.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: sh
 * @Description:
 * @Version:
 * @Date: 2020/9/28
 */
public class OldDate {

    public static void main(String[] args) {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateFormat.format(now));
        long time = now.getTime();
        time+= 24*60*60*1000;
        now.setTime(time);
        System.out.println(dateFormat.format(now));
    }
}
