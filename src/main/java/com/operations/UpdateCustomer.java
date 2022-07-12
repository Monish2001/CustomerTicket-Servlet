package com.operations;

import models.Customer;
import services.CustomerServiceDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateCustomer")
public class UpdateCustomer extends HttpServlet {
    CustomerServiceDB customerServiceDBObj = CustomerServiceDB.getInstance();
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Customer customer = new Customer();
            customer.setId(Integer.valueOf(request.getParameter("id")));
            customer.setName(request.getParameter("name"));
            customer.setEmail(request.getParameter("email"));

            Integer updatedId = customerServiceDBObj.updateCustomer(customer);
            response.sendRedirect("Success.jsp?msg=ID "+updatedId + " Updated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}