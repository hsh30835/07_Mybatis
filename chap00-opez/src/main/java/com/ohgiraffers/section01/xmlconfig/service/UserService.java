package com.ohgiraffers.section01.xmlconfig.service;

import com.ohgiraffers.dto.UserDTO;
import com.ohgiraffers.section01.xmlconfig.model.UserDAO;
import org.apache.ibatis.session.SqlSession;

import static com.ohgiraffers.common.Template.*;

import java.util.List;

public class UserService {
    private final UserDAO userDAO;

    public UserService() { this.userDAO = new UserDAO(); }
    public List<UserDTO> selectAllUser() {
        SqlSession session = getSqlsession();
        List<UserDTO> userList = userDAO.selectAllUser(session);
        session.close();
        return userList;
    }

    public UserDTO selectAllUserNumber(int code) {
        SqlSession session = getSqlsession();
        UserDTO user = userDAO.selectAllUserCode(session, code);
        session.close();
        return user;
    }

    public boolean registUser(UserDTO user) {
        SqlSession session = getSqlsession();

        int result = userDAO.registUser(session,user);

        if(result>0){
            session.commit();
        }else{
            session.rollback();
        }
        session.close();
        return result>0? true:false;
    }

    //수정
    public boolean modifyUser(UserDTO user) {
        SqlSession session = getSqlsession();
        int result = userDAO.modifyUser(session, user);

        if(result>0){
            session.commit();
        }else {
            session.rollback();
        }
        session.close();
        return result>0? true:false;
    }

    public boolean deleteUser(int code) {
        SqlSession session = getSqlsession();
        int result = userDAO.deleteUser(session, code);

        if(result>0){
            session.commit();
        }else{
            session.rollback();
        }
        session.close();
        return result>0? true:false;
    }


}
