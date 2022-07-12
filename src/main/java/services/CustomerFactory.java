package services;

public class CustomerFactory {
    public CustomerService getInstance(String str)
    {
        if(str.equals("DB"))
        {
            return new CustomerServiceDB();
        } else if (str.equals("IM")) {
            return new CustomerServiceIM();
        }
        else{
            return null;
        }
    }
    static CustomerFactory customerFactoryObj = new CustomerFactory();
    private CustomerFactory()
    {

    }
    public static CustomerFactory getCFInstance(){
        return customerFactoryObj;
    }
}
