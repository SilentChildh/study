package com.controller.user;

import com.controller.Controller;
import com.controller.util.ResponseResult;
import com.pojo.bo.user.UserLoginBO;
import com.pojo.bo.user.UserRegisterBO;
import com.pojo.dto.user.UserDTO;
import com.service.UserService;
import com.service.UserServiceImpl;

/**
 * 用户业务控制器、处理器。<br/>
 * 处理用户相关服务的调度
 * @author silent_child
 * @version 1.0
 **/

public class UserHandler implements Controller {

    //在处理器中，处理的是同一类业务，故从局部变量直接提取为成员进行复用。
    private UserService service = new UserServiceImpl();


    /**
     * 该处理器拥有：前端提供的UserLoginBO实例、服务端提供的服务接口{@link UserService}。<br/>
     * 将bo提交给服务端处理后将返回响应结果。
     * @param bo 前端封装客户端请求数据后 所提供的登录业务数据
     * @return ResponseResult<Void> 返回一个内含少量反馈数据的“响应对象” <br/>
     *      * 由于对象中data数据{@link ResponseResult} 不存在，故用Void
     */
    public ResponseResult<Void> login(UserLoginBO bo) {
        return ResponseResult.operateOthers(service.login(bo));
    }

    /**
     * 该处理器拥有：前端提供的UserRegisterBO实例、服务端提供的服务接口{@link UserService}。<br/>
     * 将bo提交给服务端处理后将返回响应结果。
     * @param bo 前端封装客户端请求数据后 所提供的注册业务数据
     * @return ResponseResult<Void> 返回一个内含少量反馈数据的“响应对象”。<br/>
     * 由于对象中data数据{@link ResponseResult} 不存在，故用Void
     */
    public ResponseResult<Void> register(UserRegisterBO bo) {
        return ResponseResult.operateOthers(service.register(bo));
    }

    /**
     * 该处理器拥有：前端提供的用户id、服务端提供的服务接口{@link UserService}。<br/>
     * 将id提交给服务端处理后将返回响应结果。
     * @param id 前端所获取到的用户id
     * @return ResponseResult<UserDTO> 返回一个内含具体dto实例，以及其他附带信息的“响应对象”
     */
    public ResponseResult<UserDTO> query(Long id) {
        //UserDTO dto = service.query(id);
        return ResponseResult.operateData(service.queryById(id));
    }
}
