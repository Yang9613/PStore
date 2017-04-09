package com.example.controller;

import com.example.model.*;
import com.example.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by MOMO on 2017/1/17.
 */
@Controller
public class PetController {
    @Autowired
    private PetService service;

    @RequestMapping("/qp/in_catid/{in_catid}")
    public String queryProducts(
            @PathVariable("in_catid")String in_catid, ModelMap map1){
        Map map=new HashMap();
        map.put("in_catid",in_catid);
        map.put("in_proid","");
        map.put("in_itemid","");

        List<Product> plist=service.queryProducts(map);
        map1.put("plist",plist);

        return "shop/viewCategory";
    }

    @RequestMapping("/qp/in_proid/{in_proid}")
    public String queryItems(
            @PathVariable("in_proid")String in_proid, ModelMap map1){
        Map map=new HashMap();
        map.put("in_catid","");
        map.put("in_proid",in_proid);
        map.put("in_itemid","");

        List<Item> ilist=service.queryItems(map);
        map1.put("ilist",ilist);

        return "shop/viewProduct";
    }

    @RequestMapping("/qp/in_itemid/{in_itemid}")
    public String queryItem(
            @PathVariable("in_itemid")String in_itemid, ModelMap map1){
        Map map=new HashMap();
        map.put("in_catid","");
        map.put("in_proid","");
        map.put("in_itemid",in_itemid);

        List<Item> item=service.queryItems(map);
        map1.put("item",item);

        return "shop/viewItem";
    }

    @RequestMapping("/cart/in_itemid/{in_itemid}/in_quantity/{in_quantity}")
    public String addCart(
            @PathVariable("in_itemid")String in_itemid,
            @PathVariable("in_quantity")String in_quantity,
            ModelMap map1
    ){
        Map map=new HashMap();
        map.put("in_itemid",in_itemid);
        map.put("in_quantity",in_quantity);
        map.put("out_orderid","");
        service.addCart(map);

        List<Cart> list=service.selectByOrderid(Integer.parseInt(map.get("out_orderid").toString()));
        map1.put("clist",list);
        return "shop/addItemToCart";


    }

    @RequestMapping("/cart/in_itemid/{in_itemid}/in_orderid/{in_orderid}")
    public String delCart(
            @PathVariable("in_itemid")String in_itemid,
            @PathVariable("in_orderid")String in_orderid,
            ModelMap map1

    ){
        CartKey key=new CartKey();
        key.setOrderid(Integer.parseInt(in_orderid));
        key.setItemid(in_itemid);
        if(service.deleteByPrimaryKey(key)>0){
            List<Cart> list=service.selectByOrderid(Integer.parseInt(in_orderid));
            map1.put("clist",list);
        }
        return "shop/addItemToCart";
    }

    @RequestMapping("/cart/update")
    public String updateCart(
            @RequestParam("itemid" )String[] itemid,
            @RequestParam("qty" )String[] qty,
            @RequestParam("oid" )String[] oid,
            ModelMap map1

    ){
        for(int i=0;i<itemid.length;i++){
            Cart c=new Cart();
            c.setItemid(itemid[i]);
            c.setOrderid(Integer.parseInt(oid[i]));
            c.setQuantity(Integer.parseInt(qty[i]));
            service.updateByPrimaryKey(c);
        }

        List<Cart> list=service.selectByOrderid(Integer.parseInt(oid[0]));
        map1.put("clist",list);
        return "shop/addItemToCart";
    }
    @RequestMapping("/cart/check/in_orderid/{orderid}/total/{total}")
    public String checkCart(@PathVariable("orderid")  String  orderid,
                            @PathVariable("total")  float  total){
        Orders orders=new Orders();
        orders.setOrderid(Integer.parseInt(orderid));
        orders.setTotalprice(new BigDecimal(total));
        orders.setOrderdate(new Date(System.currentTimeMillis()));
        service.updateByPrimaryKey(orders);
        return "shop/main";
    }
}
