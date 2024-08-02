package main.com.logout;

import main.com.generic.SubServiceimpl;
import main.com.service.Service;

public class LogoutService extends Service implements SubServiceimpl
{
    public LogoutService(String name)
    {
        super(name);
    }

    public void init()
    {
        logout();
    }

    void logout()
    {
        System.out.println("\n" + "Thank you for using our service. See you later");
        System.exit(0);
    }
}
