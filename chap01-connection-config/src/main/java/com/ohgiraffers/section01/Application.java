package com.ohgiraffers.section01;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.ibatis.transaction.managed.ManagedTransaction;
import org.apache.ibatis.transaction.managed.ManagedTransactionFactory;

import java.util.Date;

public class Application {
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/menudb";
    private static String USER = "menu";
    private static String PASS = "menu";

    public static void main(String[] args){
        /*
        * JdbcTransactionFactory : 수동 커밋
        * ManagedTransactionFactory : 오토 커밋
        * -----------------------
        * PooledDataSource : ConnectionPool을 사용함
        * UnPooledDataSource : ConnectionPool을 사용 안함
        * */
        Environment environment = new Environment("dev",
                new JdbcTransactionFactory(),
                new PooledDataSource(DRIVER, URL, USER, PASS) //커넥션풀을 사용할거냐 말거냐
        );
        //environment객체를 만듬

        Configuration config = new Configuration(environment);
        //연결할수 있는 environment객체를 만든거임

        config.addMapper(Mapper.class); //왜 class임? interface로 만든거아님?

        /*
        * SqlSessionFactory : SqlSession 객체를 생성하기 위한 팩토리 역할의 인터페이스
        * SqlSessionFactoryBuilder : SqlSessionFactory 인터페이스 타입의 하위 구현 객체를 생성하기 위한 빌드 역할
        * Build() : 설정에 대한 정보를 담고 있는 Configuration 타입의 객체 혹은 외부 설정 파일과 연관된 Stream을 매개변수로 전달하면
        *           SqlSessionFactory 인터페이스 타입의 객체를 반환하는 메소드
        * */
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        //새션팩토리는 새션을 만들기 위한것
        /*
        * openSession() : SqlSession 인터페이스 타입의 객체를 반환하는 메소드로 boolean 타입을 인자로 전달
        * - false : Connection 인터페이스 타입 객체로 Dml(update, insert, delete) 수행 후 Auto Commit에 대한 옵션을 false로 지정(권장)
        * - true : Connection 인터페이스 타입의 객체로 Dml 수행후 Auto Commit에 대한 옵션을 true로 지정
        * */
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        Mapper mapper = sqlSession.getMapper(Mapper.class); //interface에있는 Mapper
        Date date = mapper.selectSysDate();
        System.out.println(date);
        sqlSession.close();

//        Mapper mapper2 = new Mapper() { //interface에 있는 Mapper 둘이 같아야되는거 아님?
//            @Override
//            public Date selectSysDate() {
//                return null;
//            }
//        };
//        mapper2.selectSysDate();
        //interface는 추상메서드라 직접 만들수 없었음
        /*
        * 어떻게 만든진 모르겠지만 설정을 넘겨주면 몸체를 만들어준다
        *
        * */
    }
}
