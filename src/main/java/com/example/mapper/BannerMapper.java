package com.example.mapper;

import com.example.model.Banner;
import com.example.model.BannerExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface BannerMapper {
    @SelectProvider(type=BannerSqlProvider.class, method="countByExample")
    int countByExample(BannerExample example);

    @DeleteProvider(type=BannerSqlProvider.class, method="deleteByExample")
    int deleteByExample(BannerExample example);

    @Delete({
        "delete from banner",
        "where favcategory = #{favcategory,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String favcategory);

    @Insert({
        "insert into banner (favcategory, bannername)",
        "values (#{favcategory,jdbcType=VARCHAR}, #{bannername,jdbcType=VARCHAR})"
    })
    int insert(Banner record);

    @InsertProvider(type=BannerSqlProvider.class, method="insertSelective")
    int insertSelective(Banner record);

    @SelectProvider(type=BannerSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="favcategory", property="favcategory", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="bannername", property="bannername", jdbcType=JdbcType.VARCHAR)
    })
    List<Banner> selectByExample(BannerExample example);

    @Select({
        "select",
        "favcategory, bannername",
        "from banner",
        "where favcategory = #{favcategory,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="favcategory", property="favcategory", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="bannername", property="bannername", jdbcType=JdbcType.VARCHAR)
    })
    Banner selectByPrimaryKey(String favcategory);

    @UpdateProvider(type=BannerSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Banner record, @Param("example") BannerExample example);

    @UpdateProvider(type=BannerSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Banner record, @Param("example") BannerExample example);

    @UpdateProvider(type=BannerSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Banner record);

    @Update({
        "update banner",
        "set bannername = #{bannername,jdbcType=VARCHAR}",
        "where favcategory = #{favcategory,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Banner record);
}