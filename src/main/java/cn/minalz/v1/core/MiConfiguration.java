package cn.minalz.v1.core;

import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

/**
 * @description:
 * @author: minalz
 * @date: 2021-05-24 22:04
 **/
public class MiConfiguration {

    public static final ResourceBundle sqlMappings;

    static {
        sqlMappings = ResourceBundle.getBundle("misql");
    }

    public <T> T getMapper(Class<T> clazz, MiSqlSession sqlSession) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{clazz},
                new MiMapperProxy(sqlSession));
    }
}
