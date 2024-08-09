package main.com.data;

import main.com.generic.SubServiceImpl;
import main.com.service.Service;

public class DataService extends Service implements SubServiceImpl
{
    public DataService(String name)
    {
        super(name);
    }

    public void init()
    {

    }
}
