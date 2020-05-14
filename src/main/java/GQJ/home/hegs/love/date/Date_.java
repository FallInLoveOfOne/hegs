package GQJ.home.hegs.love.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @PACKAGE_NAME: GQJ.home.hegs.love.date
 * @NAME: Date_
 * @USER: SS
 * @DATE: 2020/5/14
 * @PROJECT_NAME: hegs
 **/
public class Date_ {

    /**
     * Instant         时间戳
     * Duration        持续时间、时间差
     * LocalDate       只包含日期，比如：2018-09-24
     * LocalTime       只包含时间，比如：10:32:10
     * LocalDateTime   包含日期和时间，比如：2018-09-24 10:32:10
     * Peroid          时间段
     * ZoneOffset      时区偏移量，比如：+8:00
     * ZonedDateTime   带时区的日期时间
     * Clock           时钟，可用于获取当前时间戳
     * java.time.format.DateTimeFormatter      时间格式化类
     */

    public static void main(String[] args) {
        // 年-月-日
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.toString().replace("-", ""));
        // 当天时间，没有日期
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        // 单天时间，有日期
        LocalDateTime localDateTime = LocalDateTime.now();
        String da = localDateTime.format(DateTimeFormatter.BASIC_ISO_DATE);// 20200514
        String db = localDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(da);
        System.out.println(db);
    }
}
