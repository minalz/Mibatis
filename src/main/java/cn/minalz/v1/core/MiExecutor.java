package cn.minalz.v1.core;

import cn.minalz.v1.domain.Blog;

import java.sql.*;

/**
 * @description:
 * @author: minalz
 * @date: 2021-05-24 22:04
 **/
public class MiExecutor {

    public <T> T query(String sql, Object parameter) {
        Connection conn = null;
        Statement stmt = null;
        Blog blog = new Blog();

        try {
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 打开连接
            conn = DriverManager.getConnection("jdbc:mysql://www.minalz.cn:10006/mybatis-testcase", "root", "zhouwei7");

            // 执行查询
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(String.format(sql, parameter));

            // 获取结果集
            while (rs.next()) {
                Integer bid = rs.getInt("bid");
                String name = rs.getString("name");
                Integer authorId = rs.getInt("author_id");
                blog.setAuthorId(authorId);
                blog.setBid(bid);
                blog.setName(name);
            }
            System.out.println(blog);

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return (T)blog;
    }

}
