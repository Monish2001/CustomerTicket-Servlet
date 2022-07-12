package com.operations;

import services.TicketFactory;
import services.TicketService;
import services.TicketServiceDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteTicket")
public class DeleteTicket extends HttpServlet {
    private TicketFactory tf = TicketFactory.getTFInstance();
//    private TicketService ticketServiceObj = tf.getInstance("DB");
    private TicketService ticketServiceObj = tf.getInstance("IM");
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        try {
            ticketServiceObj.deleteTicket(Integer.valueOf(request.getParameter("id")));
            response.sendRedirect("Success.jsp?msg=Delete");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
