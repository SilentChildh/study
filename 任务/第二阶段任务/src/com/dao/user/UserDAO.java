package com.dao.user;

import com.dao.BasicDAO;

import java.util.ArrayList;

/**
 * 是顶级DAO下，针对User数据访问的DAO类。<br/>
 * 内部可含对User数据操作的特有方法。
 * @author silent_child
 * @version 1.0
 **/

public class UserDAO implements BasicDAO {
    public <T> ArrayList<T> query() {

        ArrayList<T> res = new ArrayList<>();
        return res;
    }


    public int update() {
        int rows = 0;
        return rows;
    }
}
