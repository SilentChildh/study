package com.dao;

import com.pojo.dto.user.UserDTO;
import com.pojo.po.BasicPO;
import com.pojo.po.user.UserPO;

import java.io.FileInputStream;
import java.util.ArrayList;
/**
 * 仅定义增删查改的dao层接口
 * @author silent_child
 * @version 1.0
 **/

public interface BasicDAO {

    void setXml(FileInputStream xml);
    
    /**
     * 查询返回多条记录
     * @param po 承载过滤条件数据的po实例
     * @return ArrayList<UserDTO> 返回dto实例的集合
     */
    ArrayList<UserDTO> query(UserPO po);

    
    /**
     * 查询返回单条记录
     * @param po 承载过滤条件数据的po实例
     * @return UserDTO 返回单个dto实例
     */
    UserDTO querySingleLine(BasicPO po);

    
    /**
     * 查询返回单个信息
     * @param po 承载过滤条件数据的po实例
     * @return String 返回记录中指定字符信息
     */
    String querySingleField(BasicPO po);
    

    /**
     * 进行增删查改操作，返回受影响行数
     * @param po 承载过滤条件数据的po实例
     * @return int 返回记录中受影响的行数
     */
    int update(BasicPO po);



}
