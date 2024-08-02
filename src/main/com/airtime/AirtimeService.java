package main.com.airtime;

import main.com.generic.SubServiceimpl;
import main.com.service.Service;

public class AirtimeService extends Service implements SubServiceimpl
{
    public AirtimeService(String name)
    {
        super(name);
    }

    public void init()
    {

    }
}
