package services;

import com.operations.DatabaseConnection;
import models.Customer;
import models.Ticket;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketServiceDB implements TicketService{
    @Override
    public List<Ticket> getAllTickets(Integer customerId, String status) throws SQLException, ClassNotFoundException {
        Connection con = DatabaseConnection.initializeDatabase();
        PreparedStatement st;
        if(customerId==0 && status.equals(""))
        {
            st = con.prepareStatement("select * from Tickets");
        } else if (customerId!=0 && status.equals("")) {
            st = con.prepareStatement("select * from Tickets where customer_id=?");
            st.setInt(1,customerId);
        } else if (customerId==0 && (!status.equals(""))) {
            st = con.prepareStatement("select * from Tickets where status=?");
            st.setString(1,status);
        } else{
            st = con.prepareStatement("select * from Tickets where customer_id=? && status=?");
            st.setInt(1,customerId);
            st.setString(2,status);
        }

        ResultSet rs = st.executeQuery();
        List<Ticket> ticketList = new ArrayList<Ticket>();
        while (rs.next())
        {
            Ticket ticket = new Ticket();
            ticket.setId(rs.getInt("id"));
            ticket.setTitle(rs.getString("title"));
            ticket.setDescription(rs.getString("description"));
            ticket.setStatus(Ticket.TicketStatus.valueOf(rs.getString("status")));
            ticket.setCustomerId(rs.getInt("customer_id"));
            ticketList.add(ticket);
        }
        rs.close();
        st.close();
        con.close();
        return ticketList;

    }

    @Override
    public Ticket getTicketWithId(int id) throws SQLException, ClassNotFoundException {
        Connection con = DatabaseConnection.initializeDatabase();

        PreparedStatement st = con.prepareStatement("select * from Tickets where id=?");


        st.setInt(1, id);

        ResultSet rs = st.executeQuery();
        Ticket ticket = new Ticket();
        while (rs.next()) {
            ticket.setId(rs.getInt(1));
            ticket.setTitle(rs.getString(2));
            ticket.setDescription(rs.getString(3));
            ticket.setStatus(Ticket.TicketStatus.valueOf(rs.getString(4)));
            ticket.setCustomerId(rs.getInt(5));
        }

        rs.close();
        st.close();
        con.close();
        return ticket;
    }

    @Override
    public Integer createTicket(Ticket ticket) throws SQLException, ClassNotFoundException {
        Connection con = DatabaseConnection.initializeDatabase();

        PreparedStatement st = con
                .prepareStatement("insert into Tickets(title,description,status,customer_id) values(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

        st.setString(1, ticket.getTitle());
        st.setString(2, ticket.getDescription());
        st.setString(3, String.valueOf(ticket.getStatus()));
        st.setInt(4, ticket.getCustomerId());

        int affectedRows = st.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Creating ticket failed, no rows affected.");
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
                throw new SQLException("Creating ticket failed, no ID obtained.");
            }
        }
    }

    @Override
    public void deleteTicket(int id) throws SQLException, ClassNotFoundException {
        Connection con = DatabaseConnection.initializeDatabase();

        PreparedStatement st = con.prepareStatement("delete from Tickets where id=?");

        st.setInt(1, id);

        int affectedRows = st.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Deleting customer failed, no rows affected.");
        }

        st.close();
        con.close();
    }

    @Override
    public Integer updateTicket(Ticket ticket) throws SQLException, ClassNotFoundException {
        Connection con = DatabaseConnection.initializeDatabase();

        PreparedStatement st = con
                .prepareStatement("update Tickets set title=?, description=?, status=? where id=?");

        st.setString(1,ticket.getTitle());
        st.setString(2,ticket.getDescription());
        st.setString(3, String.valueOf(ticket.getStatus()));
        st.setInt(4,ticket.getId());

        int affectedRows = st.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Creating user failed, no rows affected.");
        }

        st.close();
        con.close();
        return ticket.getId();
    }

    static TicketServiceDB ticketServiceDBObj = new TicketServiceDB();
    private TicketServiceDB()
    {

    }
    public static TicketServiceDB getInstance(){
        return ticketServiceDBObj;
    }
}
