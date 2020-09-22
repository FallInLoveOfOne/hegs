package GQJ.home.hegs.love.lambda;

import java.awt.event.ActionListener;

/**
 * @Author: sh
 * @Description:
 * @Version:
 * @Date: 2020/9/21
 */
public class LaMain {

    public static void main(String[] args) {
        ActionListener actionListener=(e -> {
            System.out.println();
        });

        BooInterface bl = (x,y)->{return true;};
    }
}
