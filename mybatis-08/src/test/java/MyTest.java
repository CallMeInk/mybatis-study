import com.kuang.dao.BlogMapper;
import com.kuang.pojo.Blog;
import com.kuang.utils.IdUtils;
import com.kuang.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

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

    @Test
    public void queryBlogIFTest(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("title", "title1");
        List<Blog> blogs = mapper.queryBlogIF(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();

    }

}
