package com.operations;

import models.Customer;
import services.CustomerFactory;
import services.CustomerService;
import services.CustomerServiceDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewAllCustomer")
public class ViewAllCustomer extends HttpServlet {
    private CustomerFactory cf = CustomerFactory.getCFInstance();
//    private CustomerService customerServiceObj = cf.getInstance("DB");
    private CustomerService customerServiceObj = cf.getInstance("IM");
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            out.println("<html><body>");

            out.println("<table border=1 width=50% height=50%>");
            out.println("<tr><th>EmpId</th><th>EmpName</th><th>Salary</th><tr>");
            List<Customer> customerList = customerServiceObj.getAllCustomers();
            for (Customer customer:
                 customerList) {
                out.println("<tr><td>" + customer.getId() + "</td><td>" + customer.getName() + "</td><td>" + customer.getEmail() + "</td></tr>");
            }

            out.println("</table>");
            out.println("</html></body>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}