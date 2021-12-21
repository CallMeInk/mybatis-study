import com.kuang.dao.BlogMapper;
import com.kuang.pojo.Blog;
import com.kuang.utils.IdUtils;
import com.kuang.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;

public class MyTest {

    @Test
    public void addBlogTest(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IdUtils.getId());
        blog.setTitle("title1");
        blog.setAuthor("author1");
        blog.setCreateTime(new Date());
        blog.setViews(10);
        mapper.addBlog(blog);

        blog.setId(IdUtils.getId());
        blog.setTitle("title2");
        mapper.addBlog(blog);

        blog.setId(IdUtils.getId());
        blog.setTitle("title3");
        mapper.addBlog(blog);

        blog.setId(IdUtils.getId());
        blog.setTitle("title4");
        mapper.addBlog(blog);

        sqlSession.close();
    }

}
