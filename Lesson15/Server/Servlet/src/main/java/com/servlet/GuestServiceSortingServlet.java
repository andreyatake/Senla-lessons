package com.servlet;

import com.dao.TypeSorting;
import com.dependencyService.DependencyService;
import com.entity.Guest;
import com.entity.GuestServiceInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testHotel.controller.IHotelController;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class GuestServiceSortingServlet extends HttpServlet {

    private IHotelController hotelController = (IHotelController) DependencyService.getDI().getInstance(IHotelController.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<GuestServiceInfo> guestList = new ArrayList<GuestServiceInfo>();

        if (request.getParameter("sorting") != null) {
            TypeSorting typeSorting = this.getTypeSorting(request.getParameter("sorting"));
            if (typeSorting != null) {
                guestList = hotelController.getAllGuestServicesInfo(typeSorting);
            }
        } else {
            guestList = hotelController.getAllGuestServicesInfo(TypeSorting.NO_SORTING);
        }
        String guestListJson = ObjectConverterToJson.convertObject(guestList);
        PrintWriter pw = response.getWriter();
        pw.println(guestListJson);
    }

    public TypeSorting getTypeSorting(String queryType) {
        TypeSorting typeSorting = null;
        for (TypeSorting type : TypeSorting.values()) {
            if (type.getType().equals(queryType)) {
                typeSorting = type;
            }
        }
        return typeSorting;
    }
}
