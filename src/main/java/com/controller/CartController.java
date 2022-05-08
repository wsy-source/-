package com.controller;

import com.bean.Clientuser;
import com.bean.vo.GoodsVo;
import com.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class CartController extends BaseController {

    @Autowired
    private CartService cartService;


    @PostMapping("/addCart/{goodsid}")
    @ResponseBody
    public String addCart(@PathVariable("goodsid") Integer goodsid,
                          @RequestParam(value = "count",defaultValue = "1",required = false) Integer count) {
        HttpSession httpSession = request.getSession();
        Clientuser user = (Clientuser) httpSession.getAttribute("user");
        cartService.addCart(goodsid, user.getUserid(),count);
        return "success";
    }

    @GetMapping("/cart")
    public String toCartIndex(){
        HttpSession httpSession = request.getSession();
        Clientuser user = (Clientuser)httpSession.getAttribute("user");
        List<GoodsVo> goods = cartService.queryCartGoodsByUserId(user.getUserid());
        request.getSession().setAttribute("goods", goods);
        return "cart";
    }
}
