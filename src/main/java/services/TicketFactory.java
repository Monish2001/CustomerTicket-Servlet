package services;

public class TicketFactory {
    public TicketService getInstance(String str)
    {
        if(str.equals("DB")){
            return new TicketServiceDB();
        } else if (str.equals("IM")) {
            return new TicketServiceIM();
        }
        else{
            return null;
        }
    }
    static TicketFactory ticketFactoryObj = new TicketFactory();
    private TicketFactory()
    {

    }
    public static TicketFactory getTFInstance(){
        return ticketFactoryObj;
    }
}
