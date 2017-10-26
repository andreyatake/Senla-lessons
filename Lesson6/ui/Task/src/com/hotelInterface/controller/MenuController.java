package com.hotelInterface.controller;

import com.testHotel.controller.HotelController;
import com.hotelInterface.entity.Builder;
import com.hotelInterface.entity.Menu;
import com.hotelInterface.entity.Navigator;
import com.hotelInterface.entity.ProgramState;
import com.hotelInterface.service.ConsoleService;
import com.hotelInterface.service.MainService;

public class MenuController {

    private Builder builder;
    private Navigator navigator;

    public MenuController() {
        this.builder = new Builder();

    }

    public void run() {
        //  MainService.getMainService().setHotelController(lastHotel);

        Menu mainMenu = this.builder.buildMainMenu();
        this.navigator = new Navigator();
        Boolean running = true;

        navigator.printMenu(mainMenu);


        while (running.equals(true)) {

            int numberOfItems = navigator.getCurrentMenu().getMenuItemList().size();
            int number = ConsoleService.getConsoleService().getNumberForMenu(numberOfItems);

            if (number != 666) {
                Menu menu = navigator.navigate(number);
                navigator.printMenu(menu);
            } else {
              MainService.getMainService().saveProgramState();
                running = false;
            }
        }

    }

}