package main.com.airtime;

import main.com.generic.SubServiceImpl;
import main.com.service.Service;

public class AirtimeService extends Service implements SubServiceImpl
{
    public AirtimeService(String name)
    {
        super(name);
    }

    public void init()
    {

    }
}
