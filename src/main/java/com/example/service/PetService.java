package com.example.service;

import com.example.mapper.CartMapper;
import com.example.mapper.CategoryMapper;
import com.example.mapper.OrdersMapper;
import com.example.mapper.PetMapper;
import com.example.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by MOMO on 2017/1/17.
 */
@Service
public class PetService {
    @Autowired
    private CategoryMapper mapper;

    @Autowired
    private PetMapper pmapper;

    @Autowired
    private CartMapper cmapper;

    @Autowired
    private OrdersMapper omapper;

    public List<Category> selsectAll(){
        return mapper.selectAll();
    }

    public List<Category> selectByExample(CategoryExample example){

        return mapper.selectByExample(example);
    }

    public List<Product> queryProducts(Map map){
        return  pmapper.queryProducts(map);
    }

    public List<Item> queryItems(Map map){
        return  pmapper.queryItems(map);
    }

    public void addCart(Map map){
        pmapper.addCart(map);
    }

    public List<Cart> selectByOrderid(int orderid){
        return cmapper.selectByOrderid(orderid);
    }

    public int deleteByPrimaryKey(CartKey key){
        return cmapper.deleteByPrimaryKey(key);
    }

    public int updateByPrimaryKey(Cart record){
        return cmapper.updateByPrimaryKey(record);
    }

    public int updateByPrimaryKey(Orders record){
        return omapper.updateByPrimaryKey(record);
    }
}
