package cn.minalz.v1.core;

/**
 * @description:
 * @author: minalz
 * @date: 2021-05-24 22:04
 **/
public class MiSqlSession {

    private MiConfiguration configuration;
    private MiExecutor executor;

    public MiSqlSession(MiConfiguration configuration, MiExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T selectOne(String statement, Object paramter) {
        String sql = MiConfiguration.sqlMappings.getString(statement);
        if (null != sql && !"".equals(sql)) {
            return executor.query(sql, paramter);
        }
        return null;
    }

    public <T> T getMapper(Class clazz) {
        return (T)configuration.getMapper(clazz, this);
    }
}
