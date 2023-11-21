package com.ohgiraffers.section01.xmlconfig.model;

import com.ohgiraffers.dto.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuDAO {
    public List<MenuDTO> selectAllMenu(SqlSession sqlSession){ //모든 메뉴
        return sqlSession.selectList("MenuMapper.selectAllMenu");
        //menu-mapper.xml의 mapper namespace의 이름이 MenuMapper임
    }

    public MenuDTO selectByMenuCode(SqlSession session, int code) { //메뉴코드
        return session.selectOne("MenuMapper.selectByMenuCode", code);
        //selectOne은 첫 번째 행만 반환한다
    }

    public int registMenu(SqlSession session, MenuDTO menu) { //메뉴등록
        //public int로 준 이유 : insert, update, delete 와 같은 데이터 변경 작업에서 쓰는데
        //반환에 성공하면 1이상 실패하면 0이라서 성공여부를 판단할 수 있다.
        //String을 안쓰는 이유는 문자열을 반환하면 무슨 의미인지 알 수 가 없어서 데이터변경 작업엔 정수값을 일반적으로 사용한다
        return session.insert("MenuMapper.insert",menu);
    }
    public int modifyMenu(SqlSession session, MenuDTO menu){ //메뉴수정
        return session.update("MenuMapper.modifyMenu",menu);
    }

    public int deleteMenu(SqlSession session, int code) { //메뉴삭제
        return session.delete("MenuMapper.deleteMenu", code);
    }
}
