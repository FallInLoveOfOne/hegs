package GQJ.home.hegs.love.stream;

import java.io.Serializable;

/**
 * @PACKAGE_NAME: GQJ.home.hegs.love.stream
 * @NAME: ObVO
 * @USER: SS
 * @DATE: 2020/5/13
 * @PROJECT_NAME: hegs
 **/
public class ObVO implements Serializable {
    String id;
    String name;

    public ObVO(String id,String name){
        this.id=id;
        this.name=name;
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
