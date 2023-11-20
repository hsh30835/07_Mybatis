package com.ohgiraffers.section01;

import org.apache.ibatis.annotations.Select;

import java.util.Date;

public interface Mapper {
    @Select("SELECT CURDATE() FROM DUAL")
    //DUAL은 가상테이블
    Date selectSysDate();
}
