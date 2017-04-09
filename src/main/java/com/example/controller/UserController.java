package com.example.controller;

import com.example.model.Account;
import com.example.model.Category;
import com.example.service.PetService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;


/**
 * Created by MOMO on 2017/1/16.
 */
@Controller
public class UserController {
    @Value("${error.login.msg}")
    private String error;

    @Value("${error.register.pwd}")
    private String errorPwd;

    @Value("${error.register.xm}")
    private String errorXm;

    @Value("${error.register.email}")
    private String errorEmail;

    @Value("${error.register.category}")
    private String errorCategory;

    @Value("${error.register.all}")
    private String errorAll;

    @Autowired
    private UserService service;

    @Autowired
    private PetService pservice;

    @RequestMapping("lmain")
    public String loginmain(){
        return "shop/loginMain";
    }

    @RequestMapping("rmain")
    public String registermain(HttpSession session){
        List<Category> list=pservice.selsectAll();
        //map.put("clist",list);
        session.setAttribute("clist",list);
        return "shop/registerUser";
    }

    @RequestMapping("login")
    public String login(@ModelAttribute("user") Account account, HttpSession session, Map map){
        Account account1=service.login(account.getUsername(),account.getPassword());
        if(account1!=null){
            session.setAttribute("account",account1);
            return "shop/main";
        }else{
            map.put("error",error);
            return "shop/loginMain";
        }

    }

    @RequestMapping("register")
    public String register(@ModelAttribute("user") Account account,Map map){
        if(!account.getPassword().equals(account.getRepassword())){
            map.put("errorPwd",errorPwd);
            return "shop/registerUser";
        }

        if(account.getXm()==null){
            map.put("errorXm",errorXm);
            return "shop/registerUser";
        }

        if(!Pattern.matches("^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w+)+)$",account.getEmail())){
            map.put("errorEmail",errorEmail);
            //getCategorys(map);
            return "shop/registerUser";
        }

        if(service.register(account)){
            return "shop/loginMain";
        }

        map.put("errorAll",errorAll);
        return "shop/registerUser";


    }




}
