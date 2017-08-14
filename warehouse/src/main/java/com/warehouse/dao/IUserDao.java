package com.warehouse.dao;

import com.warehouse.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by kone on 2017-08-06.
 */
public interface IUserDao {

    /**
     * 通过用户名查找用户
     * @param username
     * @return
     */
    public User getUserByUsername(String username);

    /**
     * 新增用户
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

    public boolean updatePassword(@Param("userId") Long userId, @Param("password") String password);
}
