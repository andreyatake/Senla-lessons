package services;


import entity.Guest;
import entity.GuestRoomInfo;

import java.util.ArrayList;

public interface IGuestService {

    ArrayList<Guest> getAllGuests();
    ArrayList<Guest> getAllGuestsSortedByName();
    ArrayList<Guest> getAllGuestsSortedByDateDeparture();
    void printAllGuestsCount();
    int getPayAmount(Guest guest);
    ArrayList<GuestRoomInfo> getCurrentGuestRoomInfo();
}