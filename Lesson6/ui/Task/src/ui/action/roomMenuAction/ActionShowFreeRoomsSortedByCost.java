package ui.action.roomMenuAction;

import hotel.controller.HotelController;
import ui.entity.ActionEnumResult;
import ui.action.IAction;
import hotel.entity.Room;
import ui.service.MainService;
import hotel.services.PrinterService;

import java.util.ArrayList;

public class ActionShowFreeRoomsSortedByCost implements IAction {
    private HotelController hotelController = MainService.getMainService().getHotelController();
    private PrinterService printer=MainService.getMainService().getPrinterService();

    @Override
    public ActionEnumResult execute() {
        ArrayList<Room> roomList=hotelController.getRoomService().getFreeRooms();
        roomList= hotelController.getRoomService().getArrayRoomCostSorting(roomList);
        printer.printRooms(roomList);
        return ActionEnumResult.TRUE;
    }
}
