package com.ohgiraffers.section01;

import com.ohgiraffers.section01.DTO.CategoryDTO;
import com.ohgiraffers.section01.DTO.MenuAndCategory;

public class Application {
    public static void main(String[] args){
       ElementTestService service = new ElementTestService();

//       service.selectSqlTest();
//        MenuAndCategory menu = new MenuAndCategory();
//        menu.getCategory().setCode();
        // menu = menuAndCategory의 heap의 주소값에 접근
        // menu.getCategory() return category(type categoryDTO)

        MenuAndCategory menuAndCategory = new MenuAndCategory();
        menuAndCategory.setName("베이글 햄버거");
        menuAndCategory.setPrice(1000);
        menuAndCategory.setOrderableStatus("Y");
        menuAndCategory.setCategory(new CategoryDTO("신규 카테고리"));
        service.insertNewMenu(menuAndCategory);
    }
}
