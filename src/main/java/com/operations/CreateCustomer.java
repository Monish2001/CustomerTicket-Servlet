package com.operations;

import models.Customer;
import services.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CreateCustomer")
public class CreateCustomer extends HttpServlet {
    CustomerFactory cf = CustomerFactory.getCFInstance();
//    CustomerService customerServiceObj = cf.getInstance("DB");
    CustomerService customerServiceObj = cf.getInstance("IM");
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException
    {
        try {
            Customer customer = new Customer();
            customer.setName(request.getParameter("name"));
            customer.setEmail(request.getParameter("email"));

            Integer createdCustomerId = customerServiceObj.createCustomer(customer);

            PrintWriter out = response.getWriter();
            response.sendRedirect("Success.jsp?msg=ID "+createdCustomerId + " Inserted");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
