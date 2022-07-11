package com.operations;

import services.CustomerServiceDB;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteCustomer")
public class DeleteCustomer extends HttpServlet {
    CustomerServiceDB customerServiceDBObj = CustomerServiceDB.getInstance();
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        try {
            customerServiceDBObj.deleteCustomer(Integer.valueOf(request.getParameter("id")));
            response.sendRedirect("Success.jsp?msg=Delete");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
