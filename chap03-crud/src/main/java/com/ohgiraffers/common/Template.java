package com.ohgiraffers.common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {
    private static SqlSessionFactory sessionFactory; // 현재 sessionFactory의 값은 null임
    public static SqlSession getSqlSession(){
        if(sessionFactory == null){ // 만약에 sessionFactory가 null일시에 실행
            try {
                InputStream inputStream = Resources.getResourceAsStream("xmlconfig/mybatis-config.xml");
                //xmlconfig/mybatis-config.xml를 불러온다? 지정한다?
                sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                //sessionFactory를 생성하기 위해 SqlSessionFactoryBuilder를 만든다
                //sessionFactory는 sqlSession을 만들기 위해 사용한다
            } catch (IOException e) { // IOException에러가 날시 RuntimeException에 던진다
                throw new RuntimeException(e);
            }
        }
        return sessionFactory.openSession(false); //false로 해서 자동커밋을 수동으로 설정한다
        //그렇게 하는 이유는 여러개의 쿼리를 실행하고 그중 실패하는게 있으면 롤백하고 성공하면 커밋을 할 수 있다
    }
}
