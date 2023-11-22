package com.ohgiraffers.common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template { //Template 작성후 Application에서 get으로 주소값이 생성됐는지 먼저 확인부터 한다
    public static SqlSessionFactory sqlSessionFactory; //Sqlsession을 생성하기 위한 SqlSessionFactory를 만듬
    //현재 sqlSessionFactory의 값은 null임
    public static SqlSession getSession(){
        if(sqlSessionFactory == null){ //만약 sqlSessionFactory가 null이라면
            String resource = "config/mybatis-config.xml"; //config/mybatis-config.xml에 연결한다

            try {
                InputStream inputStream = Resources.getResourceAsStream(resource);
                //resource를 읽어온다
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                //SqlSessionFactoryBuilder가 sqlSessionFactory 생성한다
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return sqlSessionFactory.openSession(false);
        //수정 추가 삭제등 데이터 변동이 생길 때 자동커밋보다 수동커밋이 더 좋다
    }
}
