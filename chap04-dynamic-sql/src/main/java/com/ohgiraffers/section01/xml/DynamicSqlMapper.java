package com.ohgiraffers.section01.xml;

import com.ohgiraffers.common.model.MenuDTO;
import com.ohgiraffers.common.model.SearchCriteria;

import java.util.List;
import java.util.Map;

public interface DynamicSqlMapper {
    List<MenuDTO> selectMenuByPrice(Map<String, Integer> map); //문자열인

    List<MenuDTO> searchMenu(SearchCriteria searchCriteria); //하나의 값만을 찾을 것 이라 SearchCriteria가 효율적임

    List<MenuDTO> searchMenuBySupCategory(SearchCriteria searchCriteria);

    List<MenuDTO> searchMenuByRandomMenuCode(Map<String, List<Integer>> criteria);

    List<MenuDTO> searchMenuByCodeOrSearchAll(SearchCriteria criteria);

    List<MenuDTO> searchMenuByNameOrCategory(Map<String, Object> criteria);
    //키값에 Name과 Category가 있어서 하나가 아닌 여러개를 처리하기 위해 Map을 씀

    int modifyMenu(Map<String, Object> test);
    //수정은 데이터변환으로 하나만 해서 List가 필요 없음


}
