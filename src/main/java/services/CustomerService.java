package services;

import models.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {
    Customer getCustomerWithId(int id) throws SQLException, ClassNotFoundException;
    List<Customer> getAllCustomers() throws SQLException, ClassNotFoundException;
    Integer createCustomer(Customer customer) throws SQLException, ClassNotFoundException;
    Integer updateCustomer(String name, String email, int id) throws SQLException, ClassNotFoundException;
    void deleteCustomer(int id) throws SQLException, ClassNotFoundException;
}
