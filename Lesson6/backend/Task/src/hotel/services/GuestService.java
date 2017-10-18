package hotel.services;


import hotel.storage.IGuestRoomInfoStorage;
import hotel.comparator.GuestNameComparator;
import hotel.comparator.GuestRoomInfoDateComparator;
import hotel.entity.Guest;
import hotel.entity.GuestRoomInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class GuestService implements IGuestService,Serializable {

    private IGuestRoomInfoStorage guestRoomInfoStorage;
    private final Comparator<Guest>NAME_COMPARATOR=new GuestNameComparator();
    private final Comparator<GuestRoomInfo> DATE_COMPARATOR=new GuestRoomInfoDateComparator();

    public GuestService(IGuestRoomInfoStorage guestRoomInfoStorage) {
        this.guestRoomInfoStorage = guestRoomInfoStorage;

    }


    public ArrayList<Guest> getAllGuests() {
        ArrayList<Guest> allGuests = new ArrayList<Guest>();
        for (GuestRoomInfo guestRoomInfo : this.guestRoomInfoStorage.getAllEntities()) {
            if (guestRoomInfo.getStillLiving().equals(true)) {
                allGuests.add(guestRoomInfo.getGuest());
            }
        }
        return allGuests;
    }

    public ArrayList<Guest> getAllGuestsSortedByName() {
        ArrayList<Guest> copyArray = new ArrayList<Guest>(this.getAllGuests());
        copyArray.sort(NAME_COMPARATOR);
        return copyArray;
    }

    public ArrayList<Guest> getAllGuestsSortedByDateDeparture() {

        ArrayList<GuestRoomInfo> copyArray = new ArrayList<GuestRoomInfo>(this.guestRoomInfoStorage.getAllEntities());
        ArrayList<Guest> guestList = new ArrayList<Guest>();

        copyArray.sort(DATE_COMPARATOR);
        for (GuestRoomInfo guestRoomInfo : copyArray) {
            guestList.add(guestRoomInfo.getGuest());
        }

        return guestList;
    }

    public void printAllGuestsCount() {
        int count = 0;
        for (GuestRoomInfo guestRoomInfo : this.guestRoomInfoStorage.getAllEntities()) {
            if (guestRoomInfo.getStillLiving().equals(true)) {
                count++;
            }
        }
        System.out.println(new StringBuilder("All guests count: ").append(count));
    }

    public int getPayAmount(Guest guest)  {
        int payGuest = 0;
        for (GuestRoomInfo guestRoomInfo : this.guestRoomInfoStorage.getAllEntities()) {
            if (guestRoomInfo.getGuest().equals(guest)) {
                Date date1 = guestRoomInfo.getArrivalDate();
                Date date2 = guestRoomInfo.getDepartureDate();
                long diff = date2.getTime() - date1.getTime();
                int allDaysLiving = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                payGuest = allDaysLiving * guestRoomInfo.getRoom().getCost();


            }
        }
        return payGuest;
    }

    public ArrayList<GuestRoomInfo> getCurrentGuestRoomInfo() {
        ArrayList<GuestRoomInfo> currentGuestRoomInfoList = new ArrayList<GuestRoomInfo>();
        for (GuestRoomInfo guestRoomInfo : this.guestRoomInfoStorage.getAllEntities()) {
            if (guestRoomInfo.getStillLiving().equals(true)) {
                currentGuestRoomInfoList.add(guestRoomInfo);
            }

        }
        return currentGuestRoomInfoList;

    }
}
