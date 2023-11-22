package com.ohgiraffers.section01.xml;

import com.ohgiraffers.common.model.MenuDTO;
import com.ohgiraffers.common.model.SearchCriteria;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ohgiraffers.common.Template.*;
public class MenuService {
    private DynamicSqlMapper mapper;

    public void selectMenuByPrice(int price){
        SqlSession session = getSession();
        mapper = session.getMapper(DynamicSqlMapper.class);

        Map<String, Integer> map = new HashMap<>();
        map.put("price",price); //String에는 변수명을 Integer에는 그 변수명의 값을 넣어주는게 흔함
        List<MenuDTO> menuList = mapper.selectMenuByPrice(map); //map에 나온 값들을 List로 묶어줌

        if(menuList!=null && menuList.size()>0){ //menuList가 null이 아닐시 그리고 menuList의 size가 0보다 클시
            for(MenuDTO menu:menuList){ //menuList를 menu에 대입해서 true일 경우
                System.out.println(menu); //menu를 출력한다
            } //false가 될 때 까지 반복
        }else {
            System.out.println("검색 결과가 없습니다.");
        }
        session.close();
    }

    public void searchMenu(SearchCriteria searchCriteria) {
        SqlSession session = getSession(); //연결
        mapper = session.getMapper(DynamicSqlMapper.class);
        //DynamicSqlMapper는 interface(추상)이라서 사용시 class화 시켜야한다


        List<MenuDTO> menuList = mapper.searchMenu(searchCriteria);

        if (menuList != null && menuList.size() > 0) {
            for (MenuDTO menu : menuList) {
                System.out.println(menu);
            }
        } else {
            System.out.println("검색 결과가 없습니다.");
        }
        session.close();
    }

    public void searchMenuBySupCategory(SearchCriteria searchCriteria) {
        SqlSession session = getSession();
        mapper = session.getMapper(DynamicSqlMapper.class);


        List<MenuDTO> menuList = mapper.searchMenuBySupCategory(searchCriteria);

        if (menuList != null && menuList.size() > 0) {
            for (MenuDTO menu : menuList) {
                System.out.println(menu);
            }
        } else {
            System.out.println("검색 결과가 없습니다.");
        }
        session.close();
    }

    public void searchMenuByRandomMenuCode(List<Integer> randomMenuCodeList) {
        SqlSession session = getSession();
        mapper = session.getMapper(DynamicSqlMapper.class);

        Map<String, List<Integer>> codeList = new HashMap<>();
        codeList.put("randomMenuCodeList", randomMenuCodeList);

        List<MenuDTO> menuList = mapper.searchMenuByRandomMenuCode(codeList);

        if (menuList != null && menuList.size() > 0) {
            for (MenuDTO menu : menuList) {
                System.out.println(menu);
            }
        } else {
            System.out.println("검색 결과가 없습니다.");
        }
        session.close();
    }

    public void searchMenuByCodeOrSearchAll(SearchCriteria criteria) {
        SqlSession session = getSession();
        mapper = session.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.searchMenuByCodeOrSearchAll(criteria);

        if (menuList != null && menuList.size() > 0) {
            for (MenuDTO menu : menuList) {
                System.out.println(menu);
            }
        } else {
            System.out.println("검색 결과가 없습니다.");
        }
        session.close();
    }

    public void searchMenuByNameOrCategory(Map<String ,Object> criteria) {
        SqlSession session = getSession();
        mapper = session.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.searchMenuByNameOrCategory(criteria);

        if (menuList != null && menuList.size() > 0) {
            for (MenuDTO menu : menuList) {
                System.out.println(menu);
            }
        } else {
            System.out.println("검색 결과가 없습니다.");
        }
        session.close();
    }

    public void modifyMenu(Map<String ,Object> criteria) {
        SqlSession session = getSession();
        mapper = session.getMapper(DynamicSqlMapper.class);

        int result = mapper.modifyMenu(criteria);

        if(result>0){
            System.out.println("수정 성공");
        }else{
            System.out.println("수정 실패");
        }
        session.close();
    }
}
