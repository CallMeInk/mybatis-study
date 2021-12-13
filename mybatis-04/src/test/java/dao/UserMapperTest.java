package dao;

import com.kuang.dao.UserMapper;
import com.kuang.pojo.User;
import com.kuang.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    static Logger logger = Logger.getLogger(UserMapperTest.class);

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
    public void testLog4j(){
        logger.info("logger test info");
        logger.debug("logger test debug");
        logger.error("logger test error");
    }

}
