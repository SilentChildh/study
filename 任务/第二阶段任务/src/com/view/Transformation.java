package com.view;

import com.controller.user.UserHandler;
import com.controller.util.ResponseResult;
import com.pojo.bo.user.UserLoginBO;
import com.pojo.bo.user.UserRegisterBO;
import com.pojo.dto.user.UserDTO;
import com.pojo.vo.user.UserVO;
import com.util.LoggerUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Logger;
/* 对于view层还不是特别懂。
 *
 * 关于UserVO：
 * 这里不确定到底要不要依赖倒置，如果要的话那么返回类型应该是抽象的VO
 * 而在方法体内，我是打算依赖倒置，然后希望通过反射来获取所有VO。
 * 所以方法返回类型和方法体就有冲突。
 * 但是目前来说，就简单的一个UserVO倒也符合单一职责，毕竟是要在这里将DTO包装成VO的，可能专属于UserVO更好。
 * */

/**
 * 用于接收服务端输送的原生数据，并包装为VO实体
 * @author silent_child
 * @version 1.0
 **/

public class Transformation {

    Logger logger = LoggerUtil.getLoggerUtil();

    /**
     * 与客户端交互，并直接与Controller交流。<br/>
     * 通过Controller获得对象数据后，并在此包装成VO。
     * @return {@link UserVO} 返回VO实例
     */
    public UserVO getUserVO() {
        UserVO vo = new UserVO();
        UserHandler controller = new UserHandler();
        ResponseResult<UserDTO> res = null;

        //与客户交互...获得信息
        logger.info("获取用户输入信息...");


        try {
            res = controller.query(666666L,
                    new FileInputStream("E:\\Git\\3122004572-huanghehua\\任务\\第二阶段任务\\src\\dao.xml"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        /*依赖接口
        //Controller controller = new UserHandler();
        Class<? extends Controller> clazz = UserHandler.class;//Class.forName(String name);//可实现依赖注入


        try {
            //Controller controller = clazz.newInstance();

            UserHandler controller = (UserHandler) clazz.newInstance();


        } catch (InstantiationException | IllegalAccessException e) {
            logger.warning("UserVO实例获取失败...");
            throw new RuntimeException(e);
        }*/
        vo.setName(res.getData().getName() + "~~~~~~");
        vo.setEmail("~~~~~~~~~~~" + res.getData().getEmail());
        vo.setPrivilege(res.getData().getPrivilege());

        return vo;
    }

    /**
     * 在此还需与客户进行交互，以获得登录业务相关信息，并封装到bo内
     * @return {@link UserLoginBO} 返回BO实例
     */
    public UserLoginBO getUserLoginBOInfo() {
        UserLoginBO bo = new UserLoginBO();

        //与客户交互...获得信息
        logger.info("获取用户输入信息...");

        bo.setName("theShy");
        bo.setPassword("theShy");

        return bo;
    }

    /**
     * 与客户交互，以获得注册业务相关信息，并封装到bo内
     * @return {@link UserRegisterBO} 返回BO实例
     */
    public UserRegisterBO getUserRegisterBOInfo() {
        UserRegisterBO bo = new UserRegisterBO();

        //与客户交互...获得信息
        logger.info("获取用户输入信息...");

        bo.setName("theShy");
        bo.setPassword("theShy");
        bo.setEmail("123@qq.com");

        return bo;
    }

    //还有CRUD、特权功能...
}
