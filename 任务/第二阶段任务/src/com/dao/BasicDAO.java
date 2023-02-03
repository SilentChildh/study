package com.dao;

import java.io.FileInputStream;
import java.util.ArrayList;
/**
 * 仅定义增删查改的dao层接口
 * @author silent_child
 * @version 1.0
 **/

public interface BasicDAO {
    //查询返回集合
    //外部依赖xml文件，内含sql语句

    <T> ArrayList<T> query();


    //查询返回单条记录


    //查询返回单个信息


    //DML
    int update();



}
