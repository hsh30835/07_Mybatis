package com.ohgiraffers.section01.xml;

import com.ohgiraffers.common.model.MenuDTO;
import com.ohgiraffers.common.model.SearchCriteria;

import java.util.List;
import java.util.Map;

public interface DynamicSqlMapper {
    List<MenuDTO> selectMenuByPrice(Map<String, Integer> map);

    List<MenuDTO> searchMenu(SearchCriteria searchCriteria);

    List<MenuDTO> searchMenuBySupCategory(SearchCriteria searchCriteria);

    List<MenuDTO> searchMenuByRandomMenuCode(Map<String, List<Integer>> criteria);

    List<MenuDTO> searchMenuByCodeOrSearchAll(SearchCriteria criteria);

    List<MenuDTO> searchMenuByNameOrCategory(Map<String, Object> criteria);

    int modifyMenu(Map<String, Object> test);


}
