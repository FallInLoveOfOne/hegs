package GQJ.home.hegs.love.controller;

import GQJ.home.hegs.love.util.RanDom;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: sh
 * @Description:
 * @Version:
 * @Date: 2020/9/10
 */
@RestController
public class ChouJiang {
    /**
     * 模拟抽奖
     *
     * @return
     */
    @GetMapping("cj")
    public String cj() {
        return String.valueOf(RanDom.rand());
    }
}
