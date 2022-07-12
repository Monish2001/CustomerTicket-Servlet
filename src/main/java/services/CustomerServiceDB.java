package services;

import com.operations.DatabaseConnection;
import models.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerServiceDB implements CustomerService{
    @Override
    public Customer getCustomerWithId(int inputId) throws SQLException, ClassNotFoundException {
        int id = 0;
        String name = "", email = "";

        Connection con = DatabaseConnection.initializeDatabase();

        PreparedStatement st = con.prepareStatement("select * from Customers where id=?");


        st.setInt(1, inputId);

        ResultSet rs = st.executeQuery();
        Customer customer = new Customer();
        while (rs.next()) {
            id = rs.getInt(1);
            name = rs.getString(2);
            email = rs.getString(3);
        }
        customer.setId(id);
        customer.setName(name);
        customer.setEmail(email);

        rs.close();
        st.close();
        con.close();
        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() throws SQLException, ClassNotFoundException {
        Connection con = DatabaseConnection.initializeDatabase();
        PreparedStatement st = con.prepareStatement("select * from Customers");
        ResultSet rs = st.executeQuery();
        List<Customer> customerList = new ArrayList<Customer>();
        while (rs.next())
        {
            Customer customer = new Customer();
            customer.setId(rs.getInt("id"));
            customer.setName(rs.getString("name"));
            customer.setEmail(rs.getString("email"));
            customerList.add(customer);
        }
        rs.close();
        st.close();
        con.close();
        return customerList;
    }

    @Override
    public Integer createCustomer(Customer customer) throws SQLException, ClassNotFoundException {

        Connection con = DatabaseConnection.initializeDatabase();

        PreparedStatement st = con
                .prepareStatement("insert into Customers(name,email) values(?, ?)", Statement.RETURN_GENERATED_KEYS);

        st.setString(1, customer.getName());
        st.setString(2, customer.getEmail());

        int affectedRows = st.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Creating user failed, no rows affected.");
        }

        try (ResultSet generatedKeys = st.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                Integer id = generatedKeys.getInt(1);
                System.out.println("Inserted ID -" + id);
                st.close();
                con.close();
                return id;
            }
            else {
                throw new SQLException("Creating customer failed, no ID obtained.");
            }
        }
    }

    @Override
    public Integer updateCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        Connection con = DatabaseConnection.initializeDatabase();

        PreparedStatement st = con
                .prepareStatement("update Customers set name=?, email=? where id=?");

        st.setString(1,customer.getName());
        st.setString(2,customer.getEmail());
        st.setInt(3,customer.getId());

        int affectedRows = st.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Creating user failed, no rows affected.");
        }

        st.close();
        con.close();
        return customer.getId();
    }

    @Override
    public void deleteCustomer(int id) throws SQLException, ClassNotFoundException {
        Connection con = DatabaseConnection.initializeDatabase();

        PreparedStatement st = con.prepareStatement("delete from Customers where id=?");

        st.setInt(1, id);

        int affectedRows = st.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Deleting customer failed, no rows affected.");
        }

        st.close();
        con.close();
    }

    static CustomerServiceDB customerServiceDBObj = new CustomerServiceDB();
    private CustomerServiceDB()
    {

    }
    public static CustomerServiceDB getInstance(){
        return customerServiceDBObj;
    }
}
