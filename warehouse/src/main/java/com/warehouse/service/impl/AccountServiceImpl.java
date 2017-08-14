package com.warehouse.service.impl;

import com.warehouse.dao.IUserDao;
import com.warehouse.entity.User;
import com.warehouse.service.IAccountService;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by kone on 2017-08-06.
 */
@Service
public class AccountServiceImpl implements IAccountService {

    @Resource
    private IUserDao userDao;

    public boolean login(User user, HttpSession session) {
        User user2 = userDao.getUserByUsername(user.getUsername());
        if (user2 == null) {
            return false;
        } else {
            if(user.getPassword().equals(user2.getPassword())) {
                session.setAttribute("user",user2);
                return true;
            }
            return false;
        }
    }

    public boolean addUser(User user){
        user.setCreate_time(new Date());
        userDao.addUser(user);
        return false;
    }

    public boolean deleteUser(Long userId) {

        return userDao.deleteUser(userId);
    }

    public boolean changePW(String oldPassword, String newPassword, User user) {
        if(user.getPassword().equals(oldPassword)) {
            if(userDao.updatePassword(user.getId(), newPassword))
                return true;
        }
        return false;
    }
}
