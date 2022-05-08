package com.controller;

import com.bean.Clientuser;
import com.bean.vo.RegisterUser;
import com.service.RegisterUserService;
import com.service.UserService;
import com.util.ControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/user")
public class RegisterController extends BaseController {

    @Autowired
    private RegisterUserService registerUserService;

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String toRegister() {
        return "register";
    }

    @PostMapping("/doRegister")
    public String doRegister(RegisterUser registerUser,  @RequestParam("picture") MultipartFile multipartFile) {
        Assert.notNull(registerUser, "注册用户不能为空");
        String filePath = ControllerUtil.uploadImgFile(request, multipartFile);
        registerUser.setPhoto(filePath);
        registerUserService.insertRegisterUser(registerUser);
        return "redirect:/";
    }

    @PostMapping("/doCheckTel")
    @ResponseBody
    public String doCheck(@RequestParam("tel") String tel){
        Assert.notNull(tel, "手机号不能为空");
        return userService.checkUserByTel(tel);
    }

    @PostMapping("/doCheckUsername")
    @ResponseBody
    public String doCheckUsername(Clientuser clientuser){
        Assert.notNull(clientuser, "用户名不能为空");
        return userService.queryUserByConditional(clientuser);
    }
}
