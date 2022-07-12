package services;

import models.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import helpers.GenerateId;

public class CustomerServiceIM implements CustomerService{
    GenerateId generateIdObj = new GenerateId();
    Repository repositoryObj = Repository.getInstance();
    public CustomerServiceIM() {
//        super();
    }

    @Override
    public Customer getCustomerWithId(int id) throws SQLException, ClassNotFoundException {
        Map<Integer,Customer> customerMap = repositoryObj.getCustomerList();
        Customer customer = customerMap.get(id);
        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() throws SQLException, ClassNotFoundException {
        Map<Integer,Customer> customerMap = repositoryObj.getCustomerList();
        List<Customer> customerList = new ArrayList<Customer>(customerMap.values());
        return customerList;
    }

    @Override
    public Integer createCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        customer.setId(generateIdObj.gen());
        Map<Integer,Customer> customerMap = repositoryObj.getCustomerList();
        customerMap.put(customer.getId(),customer);
        return customer.getId();
    }

    @Override
    public Integer updateCustomer(Customer ipCustomer) throws SQLException, ClassNotFoundException {
        Map<Integer,Customer> customerMap = repositoryObj.getCustomerList();
        Customer customer = customerMap.get(ipCustomer.getId());
        customer.setName(ipCustomer.getName());
        customer.setEmail(ipCustomer.getEmail());
        return customer.getId();
    }

    @Override
    public void deleteCustomer(int id) throws SQLException, ClassNotFoundException {
        Map<Integer,Customer> customerMap = repositoryObj.getCustomerList();
        customerMap.remove(id);
    }
}
