package com.operations;

import services.TicketServiceDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteTicket")
public class DeleteTicket extends HttpServlet {
    TicketServiceDB ticketServiceDBObj = TicketServiceDB.getInstance();
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        try {
            ticketServiceDBObj.deleteTicket(Integer.valueOf(request.getParameter("id")));
            response.sendRedirect("Success.jsp?msg=Delete");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
