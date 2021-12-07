package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    @Test
    public void test(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();

        for(User user : userList){
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(2);

        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void getUserLike(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> user = mapper.getUserLike("%A%");

        System.out.println(user);

        sqlSession.close();
    }


    @Test
    public void addUser(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.addUser(new User(3, "cindy", "123232342"));
        if (res > 0){
            System.out.println("insert success");
            sqlSession.commit();
        }
        sqlSession.close();
    }

    @Test
    public void addUser2(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", "3");
        map.put("userName", "Cindy");
        map.put("userPwd", "asdf");
        int res = mapper.addUser2(map);
        if (res > 0){
            System.out.println("insert success");
            sqlSession.commit();
        }
        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.updateUser(new User(3, "Cindy", "123232342"));
        if (res > 0){
            System.out.println("update success");
            sqlSession.commit();
        }
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.deleteUser(3);
        if (res > 0){
            System.out.println("delete success");
            sqlSession.commit();
        }
        sqlSession.close();
    }

}
