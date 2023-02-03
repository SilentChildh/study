package com.dao;

import java.io.FileInputStream;
import java.util.ArrayList;
/**
 * 统一的顶级DAO，是向外提供访问数据库的规范接口。
 * @author silent_child
 * @version 1.0
 **/

public interface BasicDAO {
    //查询返回集合
    <T> ArrayList<T> query();


    //查询返回单条记录


    //查询返回单个信息


    //DML
    int update();



}
