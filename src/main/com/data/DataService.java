package main.com.data;

import main.com.generic.SubServiceimpl;
import main.com.service.Service;

public class DataService extends Service implements SubServiceimpl
{
    public DataService(String name)
    {
        super(name);
    }

    public void init()
    {

    }
}
