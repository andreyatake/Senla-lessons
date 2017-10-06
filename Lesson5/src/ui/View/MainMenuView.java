package ui.View;

import ui.Service.ConsoleService;
import ui.model.ViewModel;
import ui.menuItem.MenuItem;


public class MainMenuView implements IView{
    private ViewModel mainMenuViewModel;

    public MainMenuView(ViewModel mainMenuViewModel){

        this.mainMenuViewModel=mainMenuViewModel;
    }

    public void act(){
        System.out.println(mainMenuViewModel.title);
        int i=1;
        for(MenuItem menuItem:mainMenuViewModel.menuItems){
            System.out.println(i+" "+menuItem.title);
            i++;
        }

        ConsoleService consoleService=new ConsoleService();
        int number=consoleService.getNumber(mainMenuViewModel.getMenuItems().size());
        this.mainMenuViewModel.menuItems.get(number-1).click();

    }


    public void startAnoyherView(int number){}

    public ViewModel getMainMenuViewModel() {
        return mainMenuViewModel;
    }
}