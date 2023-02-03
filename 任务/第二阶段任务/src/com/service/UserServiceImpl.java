package com.service;

import com.dao.BasicDAO;
import com.dao.DAOProxyHandler;
import com.dao.user.UserDAO;
import com.pojo.bo.user.UserLoginBO;
import com.pojo.bo.user.UserPrivilege1BO;
import com.pojo.bo.user.UserPrivilege2BO;
import com.pojo.bo.user.UserRegisterBO;
import com.pojo.dto.user.UserDTO;
import com.pojo.po.user.UserPO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * 是用户业务接口的实现类，内部重写了接口的方法，以便完成业务需求。
 * <p/>
 * 成员变量声明了一个DAO实体，用于接收DAO实体的代理类。该代理类用于完成业务对数据库的操作。
 * @author silent_child
 * @version 1.0
 **/

public class UserServiceImpl implements UserService{


    //在该层下统一完成用户业务，其中会涉及到对数据库的操作，故将局部变量提取为成员变量，提高复用性。
    //获取dao的代理类,但这里是不是可以不用依赖倒置，直接用UserDAO来接收也可以，而且下面很多返回值也不用再向下转型了
    private BasicDAO dao = new DAOProxyHandler().getDaoProxy(new UserDAO());


    @Override
    public boolean login(UserLoginBO bo) {
        return false;
    }

    @Override
    public boolean register(UserRegisterBO bo) {
        return false;
    }

    @Override
    public ArrayList<UserDTO> query(UserPO po) {
        return (ArrayList<UserDTO>) dao.query(po);
    }
    @Override
    public UserDTO queryById(Long id) {
        UserPO po = new UserPO();
        po.setId(id);
        try {
            dao.setXml(new FileInputStream(XmlPath.QUERY_BY_ID));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //动态代理
        return (UserDTO) dao.querySingleLine(po);
    }


    @Override
    public void privilege1(UserPrivilege1BO bo) {

    }

    @Override
    public void privilege2(UserPrivilege2BO bo) {

    }

    /**
     * 统一存放各方法所依赖的sql语句的文件位置
     * @author silent_child
     * @version 1.0
     **/

    static class XmlPath {
        private static final String QUERY_BY_ID = "./com/service/dependency/queryById.xml";
    }
}
