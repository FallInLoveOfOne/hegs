package GQJ.home.hegs.love.lambda;

/**
 * @Author: sh
 * @Description:
 * @Date: 15:32 2020/9/21
 */
@FunctionalInterface
public interface BooInterface<T extends Number, Q extends Number> {
    boolean isBig(T t, Q q);
    //boolean test();
}
