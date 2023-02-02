package com.view;

import com.controller.Controller;
import com.controller.user.UserHandler;
import com.util.LoggerUtil;

import java.util.logging.Logger;

/**
 * 用于接收服务端输送的原生数据，并包装为VO实体
 * @author silent_child
 * @version 1.0
 **/

public class Transformation {

    Logger logger = LoggerUtil.getLoggerUtil();

    /**
     * 对于view层还不是特别懂。
     * <p/>
     * 这里不确定到底要不要依赖倒置，如果要的话那么返回类型应该是抽象的VO<br/>
     * 而在方法体内，我是打算依赖倒置，然后希望通过反射来获取所有VO。<br/>
     * 所以方法返回类型和方法体就有冲突。<br/>
     * 但是目前来说，就简单的一个UserVO倒也符合单一职责，毕竟是要在这里将DTO包装成VO的，可能专属于UserVO更好。
     *
     * @return UserVO 返回UserVO实例给客户端
     */
    public UserVO getUserVO(String name, String password) {
        //依赖接口
        //Controller controller = new UserHandler();

        Class<? extends Controller> clazz = UserHandler.class;//Class.forName(String name);//可实现依赖注入

        try {
            //Controller controller = clazz.newInstance();

            UserHandler controller = (UserHandler) clazz.newInstance();

            controller.login();




        } catch (InstantiationException e) {
            logger.warning("UserVO实例获取失败...");
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            logger.warning("UserVO实例获取失败...");
            throw new RuntimeException(e);
        }
        //如果是
    }
}
