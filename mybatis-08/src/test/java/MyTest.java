import com.kuang.dao.BlogMapper;
import com.kuang.pojo.Blog;
import com.kuang.utils.IdUtils;
import com.kuang.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

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

    @Test
    public void queryBlogWhereTest(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("title", "title2");
        List<Blog> blogs = mapper.queryBlogWhere(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void queryBlogChooseTest(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("author", "author2");
        List<Blog> blogs = mapper.queryBlogChoose(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void updateBlogTest(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap<String, String> map = new HashMap<String, String>();

        map.put("id", "c4a6819b2a4f4adf92e3a09cfdbe031d");
        map.put("title", "title change");
        mapper.updateBlog(map);
        sqlSession.close();
    }


    @Test
    public void queryBlogForEachTest(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap<String, Object> map = new HashMap<String, Object>();

        Set<Integer> ids = new HashSet<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);

        map.put("ids", ids);
//        map.put("title", "title change");
        List<Blog> blogs = mapper.queryBlogForeach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }


}
