package com.operations;

import models.Customer;
import services.CustomerServiceDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewCustomer")
public class ViewCustomer extends HttpServlet {
    CustomerServiceDB customerServiceDBObj = CustomerServiceDB.getInstance();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Customer customer = customerServiceDBObj.getCustomerWithId(Integer.valueOf(request.getParameter("id")));
            response.sendRedirect("Result.jsp?id=" + customer.getId() + "&name=" + customer.getName() + "&email=" + customer.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}