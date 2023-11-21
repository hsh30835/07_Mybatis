package com.ohgiraffers.section01.xmlconfig;
import com.ohgiraffers.section01.xmlconfig.controller.MenuController;

import java.util.HashMap;
import java.util.Map;

import static com.ohgiraffers.common.Template.*;
public class Application {
    public static void main(String[] args){
//        System.out.println(getSqlSession());
        //내가 처음에 만든 환경설정이 잘 돌아가나 먼저 확인부터 해야됨
        MenuController menuController = new MenuController();

        Map<String,String> test = new HashMap<>();
        test.put("name","테스트 메뉴");
        test.put("code", "129");
        test.put("status", "Y");
        test.put("price","3000");
        test.put("category","4");

        menuController.selectAllMenu(); //조회
//        menuController.registMenu(test); //등록
//        menuController.modifyMenu(test); //수정
//        menuController.deleteMenu(4); //삭제
    }
}
