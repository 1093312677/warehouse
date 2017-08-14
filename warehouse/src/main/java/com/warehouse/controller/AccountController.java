package com.warehouse.controller;
import com.warehouse.entity.User;
import com.warehouse.service.IAccountService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by kone on 2017-08-05.
 */
@Controller
@RequestMapping("/controller/account")
public class AccountController {
    private Logger logger = Logger.getLogger(AccountController.class);
    @Resource
    private IAccountService accountService;

    /**
     * 登录
     * @param user
     * @return
     */
    @RequestMapping("/login")
    public String login(User user, HttpSession session, HttpServletResponse response) {
        logger.info("user loging:"+user.getUsername());
        boolean result = accountService.login(user, session);
        if(result) {
            return "main";
        } else {
            try {
                response.sendRedirect("../../index.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    /**
     * 用户修改密码
     * @param newPassword
     * @param session
     * @param response
     * @return
     */
    @RequestMapping("/changePW")
    public String changePW(String oldPassword, String newPassword, HttpSession session, HttpServletResponse response) {
        logger.info("user change password:");
        User user = (User) session.getAttribute("user");
        boolean result = accountService.changePW(oldPassword, newPassword, user);
        if(result) {
            try {
                response.getWriter().print(1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                response.getWriter().print(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @RequestMapping("/removeUser")
    public String removeUser(Long userId) {
        System.out.print("ok");
        Boolean result = accountService.deleteUser(userId);
        logger.info(result);
        return "main";
    }

    /**
     * 登出
     * @param response
     * @param session
     * @return
     */
    @RequestMapping("/loginout")
    public String loginout(HttpSession session, HttpServletResponse response) {
        session.setAttribute("user",null);
        session.removeAttribute("user");
        try {
            response.sendRedirect("../../index.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
