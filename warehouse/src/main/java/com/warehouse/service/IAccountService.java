package com.warehouse.service;

import com.warehouse.entity.User;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by kone on 2017-08-06.
 */
public interface IAccountService {
    /**
     * 用户登录
     * @param user
     * @return
     */
    public boolean login(User user, HttpSession session);
    /**
     * 增加用户
     * @param user
     * @return
     */
    public boolean addUser(User user);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    public boolean deleteUser(Long userId);

    /**
     * 修改密码
     * @param oldPassword
     * @param newPassword
     * @return
     */
    public boolean changePW(String oldPassword, String newPassword, User user);
}
