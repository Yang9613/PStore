package com.example.mapper;

import com.example.model.Item;
import com.example.model.Product;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

/**
 * Created by MOMO on 2017/1/17.
 */
public interface PetMapper {
    @Select("call p_1 (" +
            " #{in_catid,mode=IN,jdbcType=VARCHAR}  ," +
            " #{in_proid,mode=IN,jdbcType=VARCHAR}  ," +
            " #{in_itemid,mode=IN,jdbcType=VARCHAR}  )")
    @Options(statementType = StatementType.CALLABLE)
    @Results({
            @Result(column="productid", property="productid", jdbcType= JdbcType.VARCHAR, id=true),
            @Result(column="catid", property="catid", jdbcType=JdbcType.VARCHAR),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="descn", property="descn", jdbcType=JdbcType.VARCHAR),
            @Result(column="pic", property="pic", jdbcType=JdbcType.VARCHAR),
            @Result(column="catid", property="category",
                    one = @One(select = "com.example.mapper.CategoryMapper.queryCategoryByid")),
    })
    List<Product> queryProducts(Map map);



    @Select("call p_1 (" +
            " #{in_catid,mode=IN,jdbcType=VARCHAR}  ," +
            " #{in_proid,mode=IN,jdbcType=VARCHAR}  ," +
            " #{in_itemid,mode=IN,jdbcType=VARCHAR}  )")
    @Options(statementType = StatementType.CALLABLE)
    @Results({
            @Result(column="itemid", property="itemid", jdbcType=JdbcType.VARCHAR, id=true),
            @Result(column="productid", property="productid", jdbcType=JdbcType.VARCHAR),
            @Result(column="listprice", property="listprice", jdbcType=JdbcType.DECIMAL),
            @Result(column="unitcost", property="unitcost", jdbcType=JdbcType.DECIMAL),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column="attr1", property="attr1", jdbcType=JdbcType.VARCHAR),
            @Result(column="attr2", property="attr2", jdbcType=JdbcType.VARCHAR),
            @Result(column="attr3", property="attr3", jdbcType=JdbcType.VARCHAR),
            @Result(column="attr4", property="attr4", jdbcType=JdbcType.VARCHAR),
            @Result(column="attr5", property="attr5", jdbcType=JdbcType.VARCHAR),
            @Result(column="productid", property="product",
                    one = @One(select = "com.example.mapper.ProductMapper.queryProductByid")),
    })

    List<Item> queryItems(Map map);



    @Insert("call p_3 (" +
            " #{in_itemid,mode=IN,jdbcType=VARCHAR}  ," +
            " #{in_quantity,mode=IN,jdbcType=VARCHAR}, " +
            " #{out_orderid,mode=OUT,jdbcType=INTEGER}  " +
            " )")
    @Options(statementType = StatementType.CALLABLE)
    void addCart(Map map);
}
