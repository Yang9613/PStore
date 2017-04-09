package com.example.mapper;

import com.example.model.Cart;
import com.example.model.CartExample;
import com.example.model.CartKey;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface CartMapper {
    @Select({
            "select",
            "orderid, itemid, quantity",
            "from cart",
            "where orderid = #{orderid,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="orderid", property="orderid", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="itemid", property="itemid", jdbcType=JdbcType.VARCHAR, id=true),
            @Result(column="quantity", property="quantity", jdbcType=JdbcType.INTEGER),
            @Result(property = "ilist",column = "itemid",javaType = List.class,
                    many = @Many(select="com.example.mapper.ItemMapper.selectItemByid"))
    })
    List<Cart> selectByOrderid(int orderid);

    @SelectProvider(type=CartSqlProvider.class, method="countByExample")
    int countByExample(CartExample example);

    @DeleteProvider(type=CartSqlProvider.class, method="deleteByExample")
    int deleteByExample(CartExample example);

    @Delete({
        "delete from cart",
        "where orderid = #{orderid,jdbcType=INTEGER}",
          "and itemid = #{itemid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(CartKey key);

    @Insert({
        "insert into cart (orderid, itemid, ",
        "quantity)",
        "values (#{orderid,jdbcType=INTEGER}, #{itemid,jdbcType=VARCHAR}, ",
        "#{quantity,jdbcType=INTEGER})"
    })
    int insert(Cart record);

    @InsertProvider(type=CartSqlProvider.class, method="insertSelective")
    int insertSelective(Cart record);

    @SelectProvider(type=CartSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="orderid", property="orderid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="itemid", property="itemid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="quantity", property="quantity", jdbcType=JdbcType.INTEGER)
    })
    List<Cart> selectByExample(CartExample example);

    @Select({
        "select",
        "orderid, itemid, quantity",
        "from cart",
        "where orderid = #{orderid,jdbcType=INTEGER}",
          "and itemid = #{itemid,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="orderid", property="orderid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="itemid", property="itemid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="quantity", property="quantity", jdbcType=JdbcType.INTEGER)
    })
    Cart selectByPrimaryKey(CartKey key);

    @UpdateProvider(type=CartSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Cart record, @Param("example") CartExample example);

    @UpdateProvider(type=CartSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Cart record, @Param("example") CartExample example);

    @UpdateProvider(type=CartSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Cart record);

    @Update({
        "update cart",
        "set quantity = #{quantity,jdbcType=INTEGER}",
        "where orderid = #{orderid,jdbcType=INTEGER}",
          "and itemid = #{itemid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Cart record);
}