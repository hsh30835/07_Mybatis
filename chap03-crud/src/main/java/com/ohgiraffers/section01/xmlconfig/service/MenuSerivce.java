package com.ohgiraffers.section01.xmlconfig.service;

import com.ohgiraffers.dto.MenuDTO;
import com.ohgiraffers.section01.xmlconfig.model.MenuDAO;
import org.apache.ibatis.session.SqlSession;
import static com.ohgiraffers.common.Template.*;
import java.util.List;

public class MenuSerivce {
    private final MenuDAO menuDAO;

    public MenuSerivce() {
        this.menuDAO = new MenuDAO();
    }

    public List<MenuDTO> selectAllMenu(){
        //모든 것을 조회할 것이라 결과를 여러개 담을 List가 적합함
        SqlSession session = getSqlSession();
        List<MenuDTO> menuList = menuDAO.selectAllMenu(session);
        session.close();
        return menuList;
    }

    public MenuDTO selectByMenuCode(int code) {
        //code만 조회할 것이라 하나의 결과만 가져올 MenuDTO를 쓰는것
        SqlSession session = getSqlSession();
        MenuDTO menu = menuDAO.selectByMenuCode(session, code);
        session.close();
        return menu;
    }

    public boolean registMenu(MenuDTO menu) { //메뉴 등록
        //if 조건절 안에 있어서 자동으로 boolean이 붙음
        SqlSession session = getSqlSession();

        int result = menuDAO.registMenu(session,menu);

        if(result>0){
            session.commit(); //결과가 0초과면 저장하는것이고 commit은 저장
        }else{
            session.rollback(); //결과가 0이하면 되돌린다 rollback은 되돌린다
        }
        session.close();
        return result>0? true:false; //삼항연산자 result>0일때 true
    }

    public boolean modifyMenu(MenuDTO menu) {
        SqlSession session = getSqlSession();

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
        SqlSession session = getSqlSession();
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
