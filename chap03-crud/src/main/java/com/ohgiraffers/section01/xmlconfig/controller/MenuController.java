package com.ohgiraffers.section01.xmlconfig.controller;

import com.ohgiraffers.common.PrintResult;
import com.ohgiraffers.dto.MenuDTO;
import com.ohgiraffers.section01.xmlconfig.service.MenuSerivce;

import java.util.List;
import java.util.Map;

public class MenuController {

    private final PrintResult printResult; //final은 변수가 한번 초기화 되면 값이 변경되지 않는다
    //한번 수정되면 값이 변하질 않아 불변성에 장점을 가진다.
    private final MenuSerivce menuSerivce;

    public MenuController() {
        this.printResult = new PrintResult();
        this.menuSerivce = new MenuSerivce();
    }

    public void selectAllMenu(){
        List<MenuDTO> menuList = menuSerivce.selectAllMenu(); //selectAllMenu의 값을 받는 menuList
        if(menuList != null){ //menuList가 null이 아닐시
            printResult.printMenuList(menuList); //menuList를 출력한다
        }else{ //그게 아니라면
            printResult.printErrorMessage("selectList"); //에러메세지중 selectList에 해당하는것을 출력한다
            //printResult에 있는 case "selectList" : message="메뉴 전체 조회 실패"; break;
        }
    }

    public void selectMenuByCode(Map<String, String> parameter){
        int code = Integer.parseInt(parameter.get("code"));
        MenuDTO menu = menuSerivce.selectByMenuCode(code);

        if(menu != null){
            printResult.printMenu(menu);
        }else{
            printResult.printErrorMessage("selectOne");
        }
    }

    public void registMenu(Map<String, String> paramter){
        String name = paramter.get("name");
        int price = Integer.parseInt(paramter.get("price"));
        int category = Integer.parseInt(paramter.get("category"));

        MenuDTO menu = new MenuDTO();
        menu.setName(name);
        menu.setCategory(category);
        menu.setPrice(price);

        if(menuSerivce.registMenu(menu)){
            printResult.printSuccessMessage("insert");
        }else{
            printResult.printErrorMessage("insert");
        }
    }

    public void modifyMenu(Map<String, String> parameter){
        int code = Integer.parseInt(parameter.get("code"));
        String name = parameter.get("name");
        int price = Integer.parseInt(parameter.get("price"));
        int category = Integer.parseInt(parameter.get("category"));
        String status = parameter.get("status");
        MenuDTO menu = new MenuDTO(code, name, price, category, status);

        if(menuSerivce.modifyMenu(menu)){
            printResult.printSuccessMessage("update");
        }else{
            printResult.printErrorMessage("update");
        }
    }

    public void deleteMenu(int code){
        if(menuSerivce.deleteMenu(code)){
            printResult.printSuccessMessage("delete");
        }else{
            printResult.printErrorMessage("delete");
        }
    }
}
