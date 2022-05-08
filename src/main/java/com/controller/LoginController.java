package com.controller;

import com.bean.Clientuser;
import com.bean.SysAdmin;
import com.service.AdminService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class LoginController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    //ajax免密登录
    @PostMapping("/autoLogin")
    @ResponseBody
    public SysAdmin login() {
        return adminService.loginAdmin();
    }


    //做登录
    @PostMapping("/doLogin")
    public String doLogin(Clientuser clientuser, @RequestParam(value = "admin",required = false) String admin) {
        if ("on".equals(admin)){
            SysAdmin sysAdmin = adminService.queryAdmin(clientuser);
            if (sysAdmin != null){
                request.getSession().setAttribute("user", sysAdmin);
                request.getSession().setAttribute("admin", sysAdmin);
            }
        }else {
            Assert.notNull(clientuser, "登录用户不能为空！");
            Clientuser user = userService.login(clientuser);
            if (user != null) {
                request.getSession().setAttribute("user", user);
            }
        }
        return "redirect:/";
    }

    //前往登录界面
    @GetMapping("login")
    public String toLogin() {
        return "login";
    }

    @GetMapping("/logout")
    public String doLogout() {
        request.getSession().removeAttribute("user");
        return "redirect:/";
    }


}
