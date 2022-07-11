package com.operations;

import models.Customer;
import services.CustomerService;
import services.CustomerServiceDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CreateCustomer")
public class CreateCustomer extends HttpServlet {
    CustomerServiceDB customerServiceDBObj = CustomerServiceDB.getInstance();
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException
    {
        try {
            Customer customer = new Customer();
            customer.setName(request.getParameter("name"));
            customer.setEmail(request.getParameter("email"));

            Integer createdCustomerId = customerServiceDBObj.createCustomer(customer);

            PrintWriter out = response.getWriter();
            response.sendRedirect("Success.jsp?msg=ID "+createdCustomerId + " Inserted");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
