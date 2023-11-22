package com.ohgiraffers.section01;

import com.ohgiraffers.section01.DTO.MenuAndCategory;
import com.ohgiraffers.section01.DTO.MenuDTO;
import com.ohgiraffers.section01.DTO.collection.CategoryAndMenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.common.Template.*;
public class ElementTestService {
    private ElementTestMapper mapper;

    public void selectCacheTest(){
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ElementTestMapper.class);

        for(int i=0; i<10; i++){
            long startTime = System.currentTimeMillis();
            List<String> nameList = mapper.selectCacheTest();
            System.out.println(nameList);
            long endTime = System.currentTimeMillis();
            long interval = endTime - startTime;

            System.out.println("수행시간 : " + interval + "(ms)");
        }
        sqlSession.close();
    }

    public void selectResultMapTest(){
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<MenuDTO> menuList = mapper.selectResultMapTest();
        for(MenuDTO menu:menuList){
            System.out.println(menu);
        }
        sqlSession.close();
    }

    public void selectResultMapConstructorTest(){
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<MenuDTO> menuList = mapper.selectResultMapConstructorTest();
        for(MenuDTO menu:menuList){
            System.out.println(menu);
        }
        sqlSession.close();
    }

    public void selectResultMapAssociationTest(){
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<MenuAndCategory> menuList = mapper.selectResultMapAssociationTest();
        for(MenuAndCategory menu:menuList){
            System.out.println(menu);
        }
        sqlSession.close();
    }

    public void selectResultMapCollectionTest(){
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<CategoryAndMenuDTO> menuList = mapper.selectResultMapCollectionTest();
        for(CategoryAndMenuDTO menu:menuList){
            System.out.println(menu);
        }
        sqlSession.close();
    }

    public void selectSqlTest(){
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<MenuDTO> menuList = mapper.selectSqlTest();
        for(MenuDTO menu:menuList){
            System.out.println(menu);
        }
        sqlSession.close();
    }

    public void insertNewMenu(MenuAndCategory menu){
        SqlSession session = getSqlSession();
        mapper = session.getMapper(ElementTestMapper.class);

        int resultCategory = mapper.insertNewCategory(menu);
        int result = mapper.insertNewMenu(menu);
        if(result>0 && resultCategory > 0){
            System.out.println("등록 성공");
            session.commit();
        }else{
            System.out.println("등록 실패");
            session.rollback();
        }
        session.close();
    }
}
