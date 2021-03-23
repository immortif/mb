package ecom.mbc;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import ecom.mbc.mappers.StudentMapper;
import ecom.mbc.mybatis.util.MybatisUtil;
import ecom.mbc.pojo.Student;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        jdbcTest();
    }

    @Test
    public void staticTest() {
        // StaticTest.staticMethod();
        // StaticTest staticTest = new StaticTest();
        try {
            Class.forName("ecom.mbc.StaticTest");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void mybatisTest() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        // studentMapper.insertByStudentEntity(new Student(5, "mbc", 5000D));
        // sqlSession.commit();
        // System.out.println("Insert student data SUCCESS!");

        // Student student = studentMapper.findStudentById(1);
        Student student = studentMapper.findStudentByColumn("name", "mbc");
        System.out.println(student.getId() + " " + student.getName() + " " + student.getSal());
    }

    /**
     * A test method of jdbc.
     */
    public void jdbcTest() {
        Connection connection = null;
        PreparedStatement prepareStatement = null;
        ResultSet rs = null;

        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取连接
            String url = "jdbc:mysql://127.0.0.1:3306/ssmdemo";
            String user = "root";
            String password = "870219";
            connection = DriverManager.getConnection(url, user, password);
            // 获取statement，preparedStatement
            String sql = "select * from tb_user where id=?";
            prepareStatement = connection.prepareStatement(sql);
            // 设置参数
            prepareStatement.setLong(1, 2l);
            // 执行查询
            rs = prepareStatement.executeQuery();
            // 处理结果集
            while (rs.next()) {
                System.out.println(rs.getString("userName"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getInt("age"));
                System.out.println(rs.getDate("birthday"));
            }
        } catch (Exception e) {
            // TODO: Something
        } finally {
            try {
                // 关闭连接，释放资源
                if (rs != null) {
                    rs.close();
                }
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
