package cn.minalz.v2.executor;

/**
 * @Author: minalz
 */
public interface Executor {
    <T> T query(String statement, Object[] parameter, Class pojo);
}
