package com.ohgiraffers.section02.javaconfig.controller;

import com.ohgiraffers.common.PrintResult;
import com.ohgiraffers.dto.MenuDTO;
import com.ohgiraffers.section02.javaconfig.service.MenuSerivce;

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

    public void selectMenuByCode(Map<String, String> parameter){ // 조회
        //Map<String, String>은 키가 문자열 값도 문자열임
        int code = Integer.parseInt(parameter.get("code"));
        //정수형 code를 가져옴
        MenuDTO menu = menuSerivce.selectByMenuCode(code);
        //MenuDTO는 조회용 code에 해당하는 값을 조회해줌?

        if(menu != null){ //menu가 null이 아닐시에
            printResult.printMenu(menu); //menuDTO를 출력하고
        }else{ //menu가 null일시
            printResult.printErrorMessage("selectOne"); //selectOne에 해당하는 에러메세지를 출력한다
        }
    }

    public void registMenu(Map<String, String> paramter){ //등록
        String name = paramter.get("name"); //name에 문자열을 입력한다
        int price = Integer.parseInt(paramter.get("price")); //price에 정수형을 입력한다
        int category = Integer.parseInt(paramter.get("categoryCode")); //category에 정수형을 입력한다

        MenuDTO menu = new MenuDTO();
        menu.setName(name); //반환
        menu.setCategoryCode(category);
        menu.setPrice(price);

        if(menuSerivce.registMenu(menu)){ //menu에 값이 있다면
            printResult.printSuccessMessage("insert"); //성공메세지 출력
        }else{ //아닐시
            printResult.printErrorMessage("insert"); //에러메세지 출력
        }
    }

    public void modifyMenu(Map<String, String> parameter){ //수정
        int code = Integer.parseInt(parameter.get("code"));
        //쿼리문에서 조건을 코드가 같을 시로 걸어놨음
        String name = parameter.get("name");
        int price = Integer.parseInt(parameter.get("price"));
        int category = Integer.parseInt(parameter.get("categoryCode"));
        String status = parameter.get("status");
        MenuDTO menu = new MenuDTO(code, name, price, category, status);

        if(menuSerivce.modifyMenu(menu)){
            printResult.printSuccessMessage("update");
        }else{
            printResult.printErrorMessage("update");
        }
    }

    public void deleteMenu(int code){ //삭제
        //code로 한 이유는 명확하고 단순한 정보는 개별 매개변수로 전달하는 것이 더 선호됨
        if(menuSerivce.deleteMenu(code)){
            printResult.printSuccessMessage("delete");
        }else{
            printResult.printErrorMessage("delete");
        }
    }
}
