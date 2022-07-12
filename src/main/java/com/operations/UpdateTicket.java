package com.operations;

import models.Customer;
import models.Ticket;
import services.CustomerServiceDB;
import services.TicketFactory;
import services.TicketService;
import services.TicketServiceDB;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateTicket")
public class UpdateTicket extends HttpServlet {
    TicketFactory tf = TicketFactory.getTFInstance();
//    TicketService ticketServiceObj = tf.getInstance("DB");
    TicketService ticketServiceObj = tf.getInstance("IM");
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Ticket ticket = new Ticket();
            ticket.setId(Integer.valueOf(request.getParameter("id")));
            ticket.setTitle(request.getParameter("title"));
            ticket.setDescription(request.getParameter("description"));
            ticket.setStatus(Ticket.TicketStatus.valueOf(request.getParameter("status")));

            Integer updatedId = ticketServiceObj.updateTicket(ticket);
            response.sendRedirect("Success.jsp?msg=ID "+updatedId + " Ticket Updated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}