package com.kuang.dao;

import com.kuang.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    //添加博客
    int addBlog(Blog blog);

    //
    List<Blog> queryBlogIF(Map map);

}
