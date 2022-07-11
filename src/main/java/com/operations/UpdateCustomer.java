package com.operations;

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
            Integer updatedId = customerServiceDBObj.updateCustomer(request.getParameter("name"),request.getParameter("email"),Integer.valueOf(request.getParameter("id")));
            response.sendRedirect("Success.jsp?msg=ID "+updatedId + " Updated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}