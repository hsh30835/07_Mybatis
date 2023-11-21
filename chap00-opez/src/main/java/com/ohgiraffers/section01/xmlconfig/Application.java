package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.section01.xmlconfig.controller.UserController;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        UserController userController = new UserController();

        Map<String,String> test =new HashMap<>();
        test.put("name","갱플랭크");
        test.put("tier","그랜드마스터");
        test.put("code","18");

        userController.selectAllUser(); //조회
//        userController.registUser(test); //추가
//        userController.modifyUser(test);//수정
//        userController.deleteUser(16); //삭제
    }
}
