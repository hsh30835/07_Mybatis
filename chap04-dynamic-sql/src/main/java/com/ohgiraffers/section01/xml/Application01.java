package com.ohgiraffers.section01.xml;

import com.ohgiraffers.common.model.SearchCriteria;

import java.util.*;

import static com.ohgiraffers.common.Template.*;
public class Application01 {
    public static void main(String[] args){
        //내가 느낀 이 코드의 흐름 가장먼저 build.gradle에서 mysql과 mybatis중 필요한것을 다운을 받고
        //독스에서 xml에 필요한거 가져와서 xml의 경로와 컬럼명을 맞게 수정한다
        //그러고 나서 연결을 위한 Template를 작성한뒤에 Applicaiton에 print(get~)으로 주소값이 잘 생성됐나 확인후
        //DTO에서 xml의 컬럼명과 동일한 변수명들을 만들어준담에 기본생성자 getter setter toString을 만들어주고
        //MenuService에서 메서드와 코드를 작성하다가 createMethod가 뜨면 Mapper interface에 메서드를 생성해준다
        //MenuSerivce에서 필요한 코드와 메서드를 작성했으면 ex)조회 메서드 Mapper.xml에서 조회 쿼리를 만들어준다
        //Applcation으로 돌아와서 실행코드를 만들고 실행한다
        MenuService menuService = new MenuService();
        menuService.selectMenuByPrice(5000); //가격이 5000이하 출력함

//        SearchCriteria criteria = new SearchCriteria("value", "식사"); //condition과 value에 해당하는 값을 출력함
//        menuService.searchMenuBySupCategory(criteria);

//        SearchCriteria criteria = new SearchCriteria("menuCode", "1");
//        menuService.searchMenuByCodeOrSearchAll(criteria);

//        menuService.searchMenuByRandomMenuCode(createRandomMenuCodeList()); //랜덤출력

        Map<String, Object> test = new HashMap<>();
        test.put("name","보리");
        test.put("categoryValue","5");
        test.put("orderableStatus","Y");
        test.put("code","1");
//        menuService.searchMenuByNameOrCategory(test); //Name 또는 Category조건 출력
//        menuService.modifyMenu(test); //수정
    }
    public static List<Integer> createRandomMenuCodeList() { //랜덤 List를 쓴 이유는 랜덤이라 값이 여러 개 들어갈 수 있으므로
        Set<Integer> set = new HashSet<>(); //Set은 중복요소를 허용 안함
        while (set.size() < 5) {
            int temp = ((int) (Math.random() * 21)) + 1;
            set.add(temp); //임의의 정수를 temp에 추가하지만 중복된 요소가 있으면 추가 안됨
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list); //Collection.sort는 오름차순 .reverseOrder는 내림차순

        return list;
    }
}
