package com.view;

import com.controller.Controller;
import com.controller.user.UserHandler;
import com.controller.util.ResponseResult;
import com.pojo.vo.user.UserVO;
import com.util.LoggerUtil;

import java.util.logging.Logger;

/**
 * 模拟客户端
 */
public class Client {
    private String xmlPath = "E:\\Git\\3122004572-huanghehua\\任务\\第二阶段任务\\src\\sql.xml";
    public void show() {
        Logger logger = LoggerUtil.getLoggerUtil();//工具类日志
        Transformation trans = new Transformation();//view层的转换器
        Controller controller = new UserHandler(xmlPath);//controller层的控制器


        logger.info("客户端请求 用户登录...");

        //获得bo业务单位后，间接通过controller、直接与UserHandler交互。
        ResponseResult<Void> res = ((UserHandler)controller).login(trans.getUserLoginBOInfo());

        if(res.getStatusCode() == 1) {
            System.out.println("登录成功...");

            logger.info("相应客户端请求 登录成功...");
        }
        else {
            System.out.println("登录失败...");

            logger.info("相应客户端请求 登录失败...");
        }



        //注册同理...



        logger.info("客户端请求 获取用户信息...");

        //通过Transformation获得VO实例，客户端不直接与Controller、UserHandler交流。
        UserVO userInfo = trans.getUserVO();
        System.out.println("您目前信息是：" + userInfo);

        switch (userInfo.getPrivilege()) {
            case 0:
                System.out.println("啥啥不是，太拉！");
                break;
            case 1:
                System.out.println("真棒啊，管理员");
                break;
            case 2:
                System.out.println("天神下凡");
                break;
            default:
        }
        logger.info("响应客户端请求获得用户信息...");
    }
}
