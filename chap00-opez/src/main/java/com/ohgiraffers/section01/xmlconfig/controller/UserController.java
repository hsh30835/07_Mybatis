package com.ohgiraffers.section01.xmlconfig.controller;

import com.ohgiraffers.common.PrintResult;
import com.ohgiraffers.dto.UserDTO;
import com.ohgiraffers.section01.xmlconfig.service.UserService;

import java.util.List;
import java.util.Map;

public class UserController {
    private final PrintResult printResult;

    private final UserService userService;

    public UserController() {
        this.printResult = new PrintResult();
        this.userService = new UserService();
    }

    public void selectAllUser(){
        List<UserDTO> userList = userService.selectAllUser();
        if(userList != null){
            printResult.printUserList(userList);
        }else {
            printResult.printErrorMessage("selectList");
        }
    }

    public void selectAllUserNumber(Map<String, String> parameter){
        int code = Integer.parseInt(parameter.get("code"));
        UserDTO user = userService.selectAllUserNumber(code);

        if(user != null){
            printResult.printUser(user);
        }else {
            printResult.printErrorMessage("selectOne");
        }
    }

    public void registUser(Map<String, String> parameter){
        String name = parameter.get("name");
        String tier = parameter.get("tier");

        UserDTO user = new UserDTO();
        user.setUserName(name);
        user.setUserTier(tier);

        if(userService.registUser(user)){
            printResult.printSuccessMessage("insert");
        }else {
            printResult.printErrorMessage("insert");
        }
    }

    //수정
    public void modifyUser(Map<String, String> parameter){
        int code = Integer.parseInt(parameter.get("code"));
        String name = parameter.get("name");
        String tier = parameter.get("tier");

        UserDTO user = new UserDTO(code, name, tier);

        if (userService.modifyUser(user)){
            printResult.printSuccessMessage("update");
        }else {
            printResult.printErrorMessage("update");
        }
    }
    public void deleteUser(int code){
        if(userService.deleteUser(code)){
            printResult.printSuccessMessage("delete");
        }else {
            printResult.printErrorMessage("delete");
        }
    }
}
