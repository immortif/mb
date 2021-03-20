package ecom.mbc.mybatis;

import org.apache.ibatis.session.SqlSession;

import ecom.mbc.mybatis.util.MybatisUtil;
import ecom.mbc.pojo.Student;

public class StudentDao {

    public void add(Student student) throws Exception {
        // 得到连接对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            // 映射文件的命名空间.SQL片段的ID，就可以调用对应的映射文件中的SQL
            sqlSession.insert("ecom.mbc.pojo.Student.add", student);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            throw e;
        } finally {
            MybatisUtil.closeSqlSession();
        }
    }

}
