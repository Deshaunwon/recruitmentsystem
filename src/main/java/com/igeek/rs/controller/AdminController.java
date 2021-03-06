package com.igeek.rs.controller;

import com.igeek.rs.entity.Admin;
import com.igeek.rs.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;

/**
 * (Admin)表控制层
 *
 * @author makejava
 * @since 2020-07-13 15:07:05
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    /**
     * 服务对象
     */
    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public String login(Admin admin, HttpSession session, Model model){
        System.out.println(admin);
        String username=admin.getUsername();
        String password=admin.getPassword();
        Admin ad = adminService.login(admin);
        if (ad != null) {
            session.setAttribute("username", username);
            session.setAttribute("loginTime", System.currentTimeMillis());
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(sdf.format(System.currentTimeMillis()));
            //return "forward:toAdminHome";
            return "forward:toUserHome";
        }
        model.addAttribute("msg", "用户名或密码错误，请重新登录");
        return "error";
    }

    @RequestMapping("/index")
    public String show(){
        return "login";
    }
    @RequestMapping("/toAdminHome")
    public String toAdminHome(){
        return "adminHome";
    }
    @RequestMapping("/toUserHome")
    public String toUserHome(){
        return "userHome";
    }
    @RequestMapping("/toUserList")
    public String torHome1(){
        return "UserList";
    }
    @RequestMapping("/toCompanyList")
    public String torHome2(){
        return "CompanyList";
    }

}