package com.operations;

import models.Customer;
import models.Ticket;
import services.CustomerServiceDB;
import services.TicketServiceDB;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewTicket")
public class ViewTicket extends HttpServlet {
    TicketServiceDB ticketServiceDBObj = TicketServiceDB.getInstance();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Ticket ticket = ticketServiceDBObj.getTicketWithId(Integer.valueOf(request.getParameter("id")));
            response.sendRedirect("TicketResult.jsp?id=" + ticket.getId() + "&title=" + ticket.getTitle() + "&description=" + ticket.getDescription() + "&status=" + ticket.getStatus() + "&customer_id=" + ticket.getCustomerId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}