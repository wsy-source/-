package com.controller;

import com.bean.Goods;
import com.bean.Goodskind;
import com.bean.dto.GoodsConditional;
import com.service.GoodsKindService;
import com.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class ShoppingController extends BaseController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsKindService goodsKindService;

    @GetMapping("/shopping")
    public String toQueryAllGoods(Model model){
        List<Goodskind> goodsKinds = goodsKindService.queryAllGoodsKind();
        HttpSession httpSession = request.getSession();
        model.addAttribute("goodsKinds",goodsKinds);
        httpSession.setAttribute("goodsKinds",goodsKinds);
        List<Goods> goods = goodsService.queryAllGoods();
        model.addAttribute("goods", goods);
        return "shopping";
     }

     @GetMapping("/goodsKind/query")
    public String toQueryGoodsByKind(GoodsConditional goodsConditional, Model model){
         String goodskind = goodsConditional.getGoodskind();
         List<Goods> kindGoods = goodsService.queryAllGoodsByGoodsConditional(goodsConditional);
         model.addAttribute("goods", kindGoods);
         model.addAttribute("goodskind",goodskind);
         return "shopping";
     }

     @GetMapping("/queryInfo/{goodsid}")
    public String queryInfoByIf(@PathVariable("goodsid") Integer goodsid, Model model){
         Goods goodsInfo = goodsService.queryGoodsById(goodsid);
         model.addAttribute("goodsInfo",goodsInfo);
         return "goodsInfo";
     }
}
