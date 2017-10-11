package action.roomMenuActions;

import action.ActionEnumResult;
import action.IAction;
import controller.HotelController;
import service.MainService;

/**
 * Created by андрей on 11.10.2017.
 */
public class ActionShowFreeRooms implements IAction {
    private HotelController hotelController = MainService.getHotelController();
    @Override
    public ActionEnumResult execute() {
       hotelController.printFreeRooms();
       return ActionEnumResult.TRUE;
    }
}
