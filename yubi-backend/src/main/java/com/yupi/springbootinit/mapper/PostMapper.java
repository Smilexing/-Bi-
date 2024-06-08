package com.yupi.springbootinit.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yupi.springbootinit.model.entity.Chart;
import com.yupi.springbootinit.model.entity.Post;
import com.yupi.springbootinit.model.entity.User;

import java.util.Date;
import java.util.List;

/**
 * 帖子数据库操作
 *
  */
public interface PostMapper extends BaseMapper<Post> {

    /**
     * 查询帖子列表（包括已被删除的数据）
     */
    List<Post> listPostWithDelete(Date minUpdateTime);

    /**
    * @author szdaiyifei
    * @description 针对表【chart(图表信息表)】的数据库操作Mapper
    * @createDate 2023-08-17 21:45:54
    * @Entity com.yupi.springbootinit.model.entity.Chart
    */
    interface ChartMapper extends BaseMapper<Chart> {

    }

    /**
    * @author szdaiyifei
    * @description 针对表【user(用户)】的数据库操作Mapper
    * @createDate 2023-08-17 21:45:54
    * @Entity com.yupi.springbootinit.model.entity.User
    */
    interface UserMapper extends BaseMapper<User> {

    }
}




