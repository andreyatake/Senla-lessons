import Entity.Guest;
import Entity.Hotel;
import Entity.Room;
import Entity.Service;
import Services.PrintIOperations;
import Services.RoomService;
import Sorting.GuestSorting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Main {


    public  static void main(String[] args){
/*
        Hotel bestHotel=new Hotel("BestHotel");
        Guest guest1=new Guest("Bob", "White");
        Guest guest2=new Guest("Jak", "White");
        Guest guest3=new Guest("Nadya", "White");

        Room room1=new Room(1,7,2,5);
        Room room2=new Room(2,5,1,4);
        Room room3=new Room(3,8,5,3);

        bestHotel.addRoom(room1);
        bestHotel.addRoom(room2);
        bestHotel.addRoom(room3);


        room1.addGuest(guest1,new GregorianCalendar(2018,8,25).getTime());
        room1.addGuest(guest2,new GregorianCalendar(2018,10,11).getTime());



        //print all rooms
        bestHotel.printAllRooms();
        bestHotel.printFreeRooms();
        System.out.println(bestHotel.getFreeRoomsCount());
        room1.printLastThreeGuests();

*/


       Hotel bestHotel=new Hotel("bestHotel");
        ArrayList<Room> newRooms= RoomService.readRoomsFromFile();
       for(Room r:newRooms){
           bestHotel.addRoom(r);
       }
       bestHotel.printAllRooms();

















    }

}
