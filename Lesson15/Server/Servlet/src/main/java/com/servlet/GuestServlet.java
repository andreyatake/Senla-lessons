package com.servlet;

import com.dao.GuestDAO;
import com.dao.IRoomDAO;
import com.dao.RoomDAO;
import com.dependencyService.DependencyService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.entity.Guest;
import com.entity.Room;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testHotel.controller.IHotelController;
import org.apache.log4j.Logger;

import static java.lang.Integer.parseInt;

public class GuestServlet extends HttpServlet {
   private IHotelController hotelController = (IHotelController) DependencyService.getDI().getInstance(IHotelController.class);
    private ObjectMapper objectMapper = new ObjectMapper();
    public static final Logger log = org.apache.log4j.Logger.getLogger(GuestServlet.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 if (request.getParameter("id") != null) {
            Integer id = parseInt(request.getParameter("id"));
            Guest guest=hotelController.getGuestById(id);
            String guestJson = ObjectConverterToJson.convertObject(guest);
            PrintWriter pw = response.getWriter();
            pw.println(guestJson);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StringBuffer sb = new StringBuffer();
        String query=null;
        BufferedReader reader = request.getReader();
        while ((query = reader.readLine()) != null) {
            sb.append(query);
        }

        try {
            Guest guest = (Guest)  this.objectMapper.readValue(sb.toString(),Guest.class);
            this.hotelController.updateGuest(guest);
            PrintWriter pw = response.getWriter();
            pw.println("succes");
        } catch (IOException e) {
            log.error(e.toString());
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StringBuffer sb = new StringBuffer();
        String query=null;
        BufferedReader reader = request.getReader();
        while ((query = reader.readLine()) != null) {
            sb.append(query);
        }

        try {
            Guest guest = (Guest)  this.objectMapper.readValue(sb.toString(),  Guest.class);
            this.hotelController.addGuest(guest);
            PrintWriter pw = response.getWriter();
            pw.println(sb);
        } catch (IOException e) {
            log.error(e.toString());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("id") != null) {
            GuestDAO guestDAO=new GuestDAO();
            Integer id = parseInt(request.getParameter("id"));
           hotelController.removeGuest(id);
            PrintWriter pw = response.getWriter();
            pw.println("succes");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}