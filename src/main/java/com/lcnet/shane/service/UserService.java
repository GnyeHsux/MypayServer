package com.lcnet.shane.service;

import com.lcnet.shane.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xushaoyin on 2017/2/16.
 */
public interface UserService extends JpaRepository<User,Long> {
    User findById(Long id);

    User findByUserNameAndUserPwd(String userName, String userPwd);



}
