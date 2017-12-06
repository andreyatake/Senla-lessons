package com.hotelInterface.action.roomMenuAction;


import com.hotelInterface.action.AAction;
import com.hotelInterface.action.IAction;
import com.hotelInterface.entity.ActionEnumResult;

public class ActionImportRooms extends AAction implements IAction {
    public ActionEnumResult execute() {

        try {
            getPrinter().printString("Enter path to file with rooms");
            String path = getConsoleService().getString();
            getClientService().importRoom(path);
            getPrinter().printString("All rooms was imported to file");
            return ActionEnumResult.TRUE;
        } catch (Exception e) {
            getPrinter().printString(e.toString());
            return ActionEnumResult.TRUE;
        }

    }

}
