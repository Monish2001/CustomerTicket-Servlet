package com.operations;

import models.Customer;
import services.CustomerFactory;
import services.CustomerService;
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
    private CustomerFactory cf = CustomerFactory.getCFInstance();
//    private CustomerService customerServiceObj = cf.getInstance("DB");
    private CustomerService customerServiceObj = cf.getInstance("IM");
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Customer customer = new Customer();
            customer.setId(Integer.valueOf(request.getParameter("id")));
            customer.setName(request.getParameter("name"));
            customer.setEmail(request.getParameter("email"));

            Integer updatedId = customerServiceObj.updateCustomer(customer);
            response.sendRedirect("Success.jsp?msg=ID "+updatedId + " Updated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}