package cn.minalz.v1.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: minalz
 * @date: 2021-05-24 22:09
 **/
public class MiMapperProxy implements InvocationHandler {

    private MiSqlSession sqlSession;

    public MiMapperProxy(MiSqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String mapperInterface = method.getDeclaringClass().getName();
        String methodName = method.getName();
        String statementId = mapperInterface + "." + methodName;
        return sqlSession.selectOne(statementId, args[0]);
    }
}
