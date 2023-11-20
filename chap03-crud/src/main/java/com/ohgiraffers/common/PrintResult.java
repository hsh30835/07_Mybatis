package com.ohgiraffers.common;

import com.ohgiraffers.dto.MenuDTO;

import java.util.List;

public class PrintResult {
    public void printMenuList(List<MenuDTO> menuList){ //메뉴리스트에 있는애들을 출력 조건에 맞을 때 까지 출력
        for(MenuDTO menu:menuList){
            System.out.println(menu);
        }
    }

    public void printMenu(MenuDTO menuDTO){ //DTO단일 출력
        System.out.println(menuDTO);
    }

    public void printSuccessMessage(String code){ //성공시 출력하는 메세지
        String message = null;
        switch (code){
            case "insert" : message ="메뉴 등록 성공"; break;
            case "update" : message ="메뉴 수정 성공"; break;
            case "delete" : message ="메뉴 삭제 성공"; break;
            default:message="잘못된 요청"; break;
        }
        System.out.println(message);
    }

    public void printErrorMessage(String code){ //실패시 출력하는 메세지
        String message = null;
        switch (code){
            case "selectList" : message="메뉴 전체 조회 실패"; break;
            case "selectOne" : message="메뉴 조회 실패"; break;
            case "insert" : message ="메뉴 등록 실패"; break;
            case "update" : message ="메뉴 수정 실패"; break;
            case "delete" : message ="메뉴 삭제 실패"; break;
            default:message="잘못된 요청"; break;
        }
        System.out.println(message);
    }
}
