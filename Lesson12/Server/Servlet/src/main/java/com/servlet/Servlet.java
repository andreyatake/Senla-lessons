package com.servlet;

import com.dao.IRoomDAO;
import com.dao.RoomDAO;
import com.dependencyService.DependencyService;
import com.entity.Room;
import com.entity.RoomStatus;
import com.testHotel.controller.IHotelController;
import com.testHotel.service.GuestService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet  extends HttpServlet{
    private String responseTemplate =
            "<html>\n" +
                    "<body>\n" +
                    "<h2>Hello from Simple Servlet</h2>\n" +
                    "</body>\n" +
                    "</html>";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      //response.setContentType("application/json;charset=UTF-8");

       // getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);




        PrintWriter pw = response.getWriter();
        Room room=new Room(20,30,40,50,999);
        IRoomDAO roomDAO=(IRoomDAO) DependencyService.getDI().getInstance(IRoomDAO.class);
      //  GuestService guestService=new GuestService();
       // guestService.getAllGuestsCount();
        //getEntityByNumber(77).getNumber()
        response.getWriter().print(roomDAO);
        response.getWriter().print(roomDAO.getClass().getName());

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(200);
        response.getWriter().write(responseTemplate);
    }

    protected void get(){}
}