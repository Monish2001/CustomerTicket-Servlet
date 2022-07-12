package com.operations;

import models.Customer;
import services.CustomerFactory;
import services.CustomerService;
import services.CustomerServiceDB;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewCustomer")
public class ViewCustomer extends HttpServlet {
    CustomerFactory cf = CustomerFactory.getCFInstance();
//    CustomerService customerServiceObj = cf.getInstance("DB");
    CustomerService customerServiceObj = cf.getInstance("IM");
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Customer customer = customerServiceObj.getCustomerWithId(Integer.valueOf(request.getParameter("id")));
            response.sendRedirect("Result.jsp?id=" + customer.getId() + "&name=" + customer.getName() + "&email=" + customer.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}