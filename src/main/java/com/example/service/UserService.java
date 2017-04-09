package com.example.service;

import com.example.mapper.AccountMapper;
import com.example.mapper.ProfileMapper;
import com.example.model.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by MOMO on 2017/1/16.
 */
@Service
public class UserService {
    @Autowired
    private AccountMapper mapper;

    @Autowired
    private ProfileMapper pmapper;

    public Account login(String username,String password){
        return mapper.login(username,password);
    }

    public boolean register(@Param("account") Account account){
        account.getProfile().setUsername(account.getUsername());
        return (mapper.insert(account)>0)&&(pmapper.insert(account.getProfile())>0);
    }

}
