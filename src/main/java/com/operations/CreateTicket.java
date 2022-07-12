package com.operations;
import models.Customer;
import models.Ticket;
import services.CustomerServiceDB;
import services.TicketFactory;
import services.TicketService;
import services.TicketServiceDB;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateTicket")
public class CreateTicket extends HttpServlet {
    private TicketFactory tf = TicketFactory.getTFInstance();

//    private TicketService ticketServiceObj = tf.getInstance("DB");
    private TicketService ticketServiceObj = tf.getInstance("IM");
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException
    {
        try {
            Ticket ticket = new Ticket();
            ticket.setTitle(request.getParameter("title"));
            ticket.setDescription(request.getParameter("description"));
            ticket.setStatus(Ticket.TicketStatus.INITIATED);
            ticket.setCustomerId(Integer.valueOf(request.getParameter("customer_id")));

            Integer createdTicketId = ticketServiceObj.createTicket(ticket);

            PrintWriter out = response.getWriter();
            response.sendRedirect("Success.jsp?msg=ID "+createdTicketId + " Created");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
