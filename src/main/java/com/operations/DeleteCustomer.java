package com.operations;

import services.CustomerFactory;
import services.CustomerService;
import services.CustomerServiceDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteCustomer")
public class DeleteCustomer extends HttpServlet {
    private CustomerFactory cf = CustomerFactory.getCFInstance();
//    private CustomerService customerServiceObj = cf.getInstance("DB");
    private CustomerService customerServiceObj = cf.getInstance("IM");
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        try {
            customerServiceObj.deleteCustomer(Integer.valueOf(request.getParameter("id")));
            response.sendRedirect("Success.jsp?msg=Delete");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
