package services;

import models.Customer;
import models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class Repository {
    final private Map<Integer, Ticket> ticketList;
    final private Map<Integer, Customer> customerList;

    public Map<Integer, Ticket> getTicketList() {
        return ticketList;
    }

    public Map<Integer, Customer> getCustomerList() {
        return customerList;
    }

    static Repository repositoryObj = new Repository();
    private Repository()
    {
        this.ticketList = new HashMap<Integer, Ticket>();
        this.customerList = new HashMap<Integer, Customer>();
    }
    public static Repository getInstance(){
        return repositoryObj;
    }
}