package com.ohgiraffers.section03.remix;

import com.ohgiraffers.section03.remix.controller.MenuController;


public class Application {
    public static void main(String[] args) {

        MenuController menu = new MenuController();
        menu.selectAllMenu();
    }
}