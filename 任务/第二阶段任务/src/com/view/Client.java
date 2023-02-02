package com.view;

import com.util.LoggerUtil;

import java.util.logging.Logger;


public class Client {
    public void show() {

        Logger logger = LoggerUtil.getLoggerUtil();


        Transformation trans = new Transformation();

        logger.info("客户端请求 用户登录...");

        logger.info("相应客户端请求 登录成功...");


        logger.info("客户端请求 获取用户信息...");

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
