package com.kuang.dao;

import com.kuang.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    //添加博客
    int addBlog(Blog blog);

    int updateBlog(Map map);

    List<Blog> queryBlogIF(Map map);

    List<Blog> queryBlogWhere(Map map);

    List<Blog> queryBlogChoose(Map map);

    List<Blog> queryBlogForeach(Map map);

}
