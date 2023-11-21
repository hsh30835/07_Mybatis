package com.ohgiraffers.section02.javaconfig.service;

import com.ohgiraffers.dto.MenuDTO;
import com.ohgiraffers.section02.javaconfig.model.JavaMenuDAO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.common.Template.*;
import static com.ohgiraffers.common.Template.getRemixSession;

public class MenuSerivce {
    private JavaMenuDAO menuDAO;

    public List<MenuDTO> selectAllMenu(){
        //모든 것을 조회할 것이라 결과를 여러개 담을 List가 적합함
        SqlSession session = getJavaSqlSession();

        menuDAO = session.getMapper(JavaMenuDAO.class);
        List<MenuDTO> menuList = menuDAO.selectAllMenu(session);
        session.close();
        return menuList;
    }

    public MenuDTO selectByMenuCode(int code) {
        //code만 조회할 것이라 하나의 결과만 가져올 MenuDTO를 쓰는것
        SqlSession session = getJavaSqlSession();

        menuDAO = session.getMapper(JavaMenuDAO.class);
        MenuDTO menu = menuDAO.selectByMenuCode(code);
        session.close();
        return menu;
    }

    public boolean registMenu(MenuDTO menu) { //메뉴 등록
        //if 조건절 안에 있어서 자동으로 boolean이 붙음
        SqlSession session = getJavaSqlSession();

        menuDAO = session.getMapper(JavaMenuDAO.class);

        int result = menuDAO.registMenu(menu);

        if(result>0){
            session.commit(); //결과가 0초과면 저장하는것이고 commit은 저장
        }else{
            session.rollback(); //결과가 0이하면 되돌린다 rollback은 되돌린다
        }
        session.close();
        return result>0? true:false; //삼항연산자 result>0일때 true
    }

    public boolean modifyMenu(MenuDTO menu) {
        SqlSession session = getJavaSqlSession();

        menuDAO = session.getMapper(JavaMenuDAO.class);

        int result = menuDAO.modifyMenu(session,menu);
        if(result>0){
            session.commit();
        }else{
            session.rollback();
        }
        session.close();
        return result>0? true:false;
    }

    public boolean deleteMenu(int code) {
        SqlSession session = getRemixSession();

        menuDAO = session.getMapper(JavaMenuDAO.class);
        int result = menuDAO.deleteMenu(session, code);

        if(result>0){
            session.commit();
        }else{
            session.rollback();
        }
        session.close();

        return result>0? true:false;
    }
}
