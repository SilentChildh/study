package com.dao;

import java.util.ArrayList;
/**
 * 统一的顶级DAO，是向外提供访问数据库的规范接口。
 * @author silent_child
 * @version 1.0
 **/

public interface BasicDAO {
    default <T> ArrayList<T> query() {

        ArrayList<T> res = new ArrayList<>();
        return res;
    }

    default int update() {
        int rows = 0;
        return rows;
    }


}
