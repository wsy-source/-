package com.controller;

import com.bean.Goods;
import com.bean.vo.OrderVo;
import com.bean.vo.UpdateOrderVo;
import com.github.pagehelper.PageInfo;
import com.service.GoodsService;
import com.service.OrderService;
import com.util.ControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/manage")
    public String toManage(Model model,
                           @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                           @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        PageInfo<OrderVo> orders = orderService.queryAdminOrders(pageNum, pageSize);
        model.addAttribute("orders", orders);
        return "orderManage";
    }

    @GetMapping("/toProcess")
    public String toProcess(@RequestParam("id") Integer id, Model model) {
        OrderVo orderVo = orderService.queryAdminOrderById(id);
        model.addAttribute("order", orderVo);
        return "process";
    }

    @PostMapping("/process")
    public String process(UpdateOrderVo updateOrderVo) {
        orderService.updateOrderInfo(updateOrderVo);
        return "redirect:manage";
    }


    @GetMapping("/uploadGoods")
    public String toUploadGoods() {
        return "uploadGoods";
    }

    @PostMapping("/doUploadGoods")
    @ResponseBody
    public String douploadGoods(Goods goods, @RequestParam("photo") MultipartFile multipartFile) {
        String realPath = ControllerUtil.uploadImgFile(request, multipartFile);
        goods.setImg(realPath);
        Integer integer = goodsService.insertGoods(goods);
        if (integer != 0) {
            return "success";
        }else {
            return "fail";
        }
    }

}
