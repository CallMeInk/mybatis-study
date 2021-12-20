import com.kuang.dao.TeacherMapper;
import com.kuang.pojo.Teacher;
import com.kuang.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TeacherTest {

    @Test
    public void getTeacherTest() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teacherList = mapper.getTeacher();
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
        sqlSession.close();
    }

    @Test
    public void getTeacherByTidTest() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = teacherMapper.getTeacherByTid(1);
        System.out.println(teacher);
        sqlSession.close();
    }

    @Test
    public void getTeacherByTidTest2() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = teacherMapper.getTeacherByTid2(1);
        System.out.println("----------------result---------------");
        System.out.println(teacher);
        sqlSession.close();
    }


}
