package com.operations;

import models.Ticket;
import services.TicketServiceDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewAllTicket")
public class ViewAllTicket extends HttpServlet {
    TicketServiceDB ticketServiceDBObj = TicketServiceDB.getInstance();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            out.println("<html><body>");

            out.println("<table border=1 width=50% height=50%>");
            out.println("<tr><th>TicketId</th><th>Title</th><th>Description</th><th>Status</th><th>CustomerId</th><tr>");
            String custId = "";
            custId = request.getParameter("customer_id");
            Integer customerId = 0;
            if(custId!="")
            {
                customerId = Integer.valueOf(custId);
            }

            String status = request.getParameter("status");
            List<Ticket> ticketList = ticketServiceDBObj.getAllTickets(customerId, status);
            for (Ticket ticket:
                    ticketList) {
                out.println("<tr><td>" + ticket.getId() + "</td><td>" + ticket.getTitle() + "</td><td>" + ticket.getDescription() + "</td><td>" + ticket.getStatus() + "</td><td>" + ticket.getCustomerId() + "</td></tr>");
            }

            out.println("</table>");
            out.println("</html></body>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}