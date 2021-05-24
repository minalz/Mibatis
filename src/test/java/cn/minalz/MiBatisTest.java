package cn.minalz;

import cn.minalz.v1.core.MiExecutor;
import cn.minalz.v1.mapper.BlogMapper;
import cn.minalz.v1.core.MiConfiguration;
import cn.minalz.v1.core.MiSqlSession;

/**
 * @description:
 * @author: minalz
 * @date: 2021-05-24 22:26
 **/
public class MiBatisTest {

    public static void main(String[] args) {
        MiSqlSession sqlSession = new MiSqlSession(new MiConfiguration(), new MiExecutor());
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        blogMapper.selectBlogById(1);
    }

    /**
     * 测试成功 但是还有一些不足
     * 1.Executor中，对参数、语句和结果集的处理是耦合的，没有实现职责分离
     * 2.参数：没有实现对语句的预编译，只有简单的格式化(format)，效率不高，还存在SQL注入的风险
     * 3.语句执行：数据库连接硬编码
     * 4.结果集：只能处理Blog类型，没有实现根据实体类自动映射
     */
}
