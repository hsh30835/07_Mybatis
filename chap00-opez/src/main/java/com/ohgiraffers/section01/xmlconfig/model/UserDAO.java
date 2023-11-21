package com.ohgiraffers.section01.xmlconfig.model;

import com.ohgiraffers.dto.UserDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDAO {
    public List<UserDTO> selectAllUser(SqlSession sqlSession){
        return sqlSession.selectList("UserMapper.selectAllUser");
    }
    public UserDTO selectAllUserCode(SqlSession session, int code){
        return session.selectOne("UserMapper.selectAllUserCode", code);
    }

    public int registUser(SqlSession session, UserDTO user){
        return session.insert("UserMapper.insertUser",user);
    }

    //수정
    public int modifyUser(SqlSession session, UserDTO user){
        return session.update("UserMapper.modifyUser", user);
    }

    public int deleteUser(SqlSession session, int code){
        return session.delete("UserMapper.deleteUser", code);
    }
}
