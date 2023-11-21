package com.ohgiraffers.common;

import com.ohgiraffers.section02.javaconfig.model.JavaMenuDAO;
import com.ohgiraffers.section03.remix.model.RemixMenuDAO;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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
    public static SqlSession getJavaSqlSession() {
        if (sessionFactory == null) {
            try {
                Properties properties = new Properties();
                properties.load(new FileReader("src/main/resources/javaconfig/javaconfig.properties"));
                String driver = properties.getProperty("DRIVER");
                String url = properties.getProperty("URL");
                String user = properties.getProperty("USER");
                String pass = properties.getProperty("PASS");

                Environment environment = new Environment("dev",
                        new JdbcTransactionFactory(),
                        new PooledDataSource(driver,url,user,pass)
                );
                Configuration configuration = new Configuration(environment);
                configuration.addMapper(JavaMenuDAO.class);

                sessionFactory = new SqlSessionFactoryBuilder().build(configuration);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return sessionFactory.openSession(false);
    }
    public static SqlSession getRemixSession() {
        if (sessionFactory == null) {
            try {
                Properties properties = new Properties();
                properties.load(new FileReader("src/main/resources/javaconfig/javaconfig.properties"));
                String driver = properties.getProperty("DRIVER");
                String url = properties.getProperty("URL");
                String user = properties.getProperty("USER");
                String pass = properties.getProperty("PASS");

                Environment environment = new Environment("dev",
                        new JdbcTransactionFactory(),
                        new PooledDataSource(driver,url,user,pass)
                );
                Configuration configuration = new Configuration(environment);
                configuration.addMapper(RemixMenuDAO.class);

                sessionFactory = new SqlSessionFactoryBuilder().build(configuration);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return sessionFactory.openSession(false);
    }


}
