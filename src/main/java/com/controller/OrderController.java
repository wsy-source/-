package com.controller;

import com.bean.Clientuser;
import com.bean.state.CartState;
import com.bean.vo.GoodsVo;
import com.service.AllOrder;
import com.service.CartService;
import com.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class OrderController extends BaseController{

    @Autowired
    private AllOrder order;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderDetailService orderDetailService;

    @PostMapping("/payment")
    @ResponseBody
    public Double payment(@RequestParam("goodsid")List<Integer> goodsid){
        request.getSession().setAttribute("paymentGoods",goodsid);
        Double money = 0.0;
        Clientuser user = (Clientuser) request.getSession().getAttribute("user");
        List<GoodsVo> goods = (List<GoodsVo>) request.getSession().getAttribute("goods");
        for (int i = 0; i < goods.size(); i++) {
            for (int j = 0; j < goodsid.size(); j++) {
                if (goods.get(i).getGoodsid()==goodsid.get(j)){
                    money+=goods.get(i).getPrice()*goods.get(i).getCnt();
                    order.insertOrderAndOrderDetail(user,goods.get(i));
                }
            }
        }

        return money;
    }

    @GetMapping("/toPay")
    public String toPay(){
        return "payment";
    }

    @GetMapping("/paymentSuccess")
    public String paymentSuccess(){
        List<Integer> paymentGoodsId = (List<Integer>) request.getSession().getAttribute("paymentGoods");
        Clientuser user = (Clientuser) request.getSession().getAttribute("user");
        cartService.updateCartState(paymentGoodsId,user.getUserid(), CartState.full);
        return "redirect:shopping";
    }

}
