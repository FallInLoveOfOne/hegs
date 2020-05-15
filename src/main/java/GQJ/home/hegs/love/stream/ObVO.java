package GQJ.home.hegs.love.stream;

import java.io.Serializable;

/**
 * @PACKAGE_NAME: GQJ.home.hegs.love.stream
 * @NAME: ObVO
 * @USER: SS
 * @DATE: 2020/5/13
 * @PROJECT_NAME: hegs
 **/
public class ObVO implements Comparable<ObVO>,Serializable {
    String id;
    String name;
    Integer yearOld;

    public ObVO(String id, String name, Integer yearOld) {
        this.id = id;
        this.name = name;
        this.yearOld = yearOld;
    }

    @Override
    public int compareTo(ObVO o) {
        //return -(this.yearOld-o.yearOld);
        //return 0;// 升序，自上往下
        //return -1;// 降序，自上往下（从大到小）
        return 1;// 升序，自上往下
    }

    public Integer getYearOld() {
        return yearOld;
    }

    public void setYearOld(Integer yearOld) {
        this.yearOld = yearOld;
    }




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
