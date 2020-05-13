package GQJ.home.hegs.love.string;

/**
 * 字符串截取说明
 */
public class sub {

    public static void main(String[] args) {
        // 字符串初始角标为：0
        String val = "0123456789";
        System.out.println(val.substring(1));
        // 从第二位开始截取，截取（8-1）位：左闭右开[1,8)
        System.out.println(val.substring(1,8));
    }
}
