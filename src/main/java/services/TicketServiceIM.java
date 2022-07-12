package services;

import helpers.GenerateId;
import models.Customer;
import models.Ticket;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TicketServiceIM implements TicketService {
    GenerateId generateIdObj = new GenerateId();
    Repository repositoryObj = Repository.getInstance();
    public TicketServiceIM(){

    }

    @Override
    public List<Ticket> getAllTickets(Integer customerId, String status) throws SQLException, ClassNotFoundException {
        Map<Integer, Ticket> ticketMap = repositoryObj.getTicketList();
        List<Ticket> ticketList = new ArrayList<Ticket>(ticketMap.values());
        return ticketList;

    }

    @Override
    public Ticket getTicketWithId(int id) throws SQLException, ClassNotFoundException {
        Map<Integer, Ticket> ticketMap = repositoryObj.getTicketList();
        Ticket ticket = ticketMap.get(id);
        return  ticket;
    }

    @Override
    public Integer createTicket(Ticket ticket) throws SQLException, ClassNotFoundException {
        ticket.setId(generateIdObj.gen());
        Map<Integer, Ticket> ticketMap = repositoryObj.getTicketList();
        ticketMap.put(ticket.getId(),ticket);
        return ticket.getId();
    }

    @Override
    public void deleteTicket(int id) throws SQLException, ClassNotFoundException {
        Map<Integer, Ticket> ticketMap = repositoryObj.getTicketList();
        ticketMap.remove(id);
    }

    @Override
    public Integer updateTicket(Ticket ipTicket) throws SQLException, ClassNotFoundException {
        Map<Integer, Ticket> ticketMap = repositoryObj.getTicketList();
        Ticket ticket = ticketMap.get(ipTicket.getId());
        ticket.setStatus(ipTicket.getStatus());
        ticket.setTitle(ipTicket.getTitle());
        ticket.setDescription(ipTicket.getDescription());
        return ticket.getId();
    }
}
