package services;

import models.Ticket;

import java.sql.SQLException;
import java.util.List;

public interface TicketService {
    List<Ticket> getAllTickets(Integer customerId, String status) throws SQLException, ClassNotFoundException;
    Ticket getTicketWithId(int id) throws SQLException, ClassNotFoundException;
    Integer createTicket(Ticket ticket) throws SQLException, ClassNotFoundException;
    void deleteTicket(int id) throws SQLException, ClassNotFoundException;
    Integer updateTicket(Ticket ticket) throws SQLException, ClassNotFoundException;
}
